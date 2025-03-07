const startScreen = document.getElementById('start-screen');
const gameScreen = document.getElementById('game-screen');
const endScreen = document.getElementById('end-screen');
const loadingScreen = document.getElementById('loading-screen');

const categorySelect = document.getElementById('category');
const difficultySelect = document.getElementById('difficulty');
const amountSelect = document.getElementById('amount');
const btnStart = document.getElementById('start-btn');

const questionText = document.getElementById('question-text');
const optionsContainer = document.getElementById('options-container');
const scoreElement = document.getElementById('score');
const currentQuestionElement = document.getElementById('current-question');
const totalQuestionsElement = document.getElementById('total-questions');
const timerBar = document.getElementById('timer-bar');
const timerText = document.getElementById('timer-text');

const feedback = document.getElementById('feedback');
const feedbackText = document.getElementById('feedback-text');
const btnNext = document.getElementById('next-btn');

const finalScoreElement = document.getElementById('final-score');
const maxScoreElement = document.getElementById('max-score');
const btnplayAgain = document.getElementById('play-again-btn');

let questions = [];
let currentQuestionIndex = 0;
let score = 0;
let timer;
let timeLeft = 15;
let timerInterval;

btnStart.addEventListener('click', startGame);
btnNext.addEventListener('click', loadNextQuestion);
btnplayAgain.addEventListener('click', resetGame);

function decodeHTML(html) {
    const txt = document.createElement('textarea');
    txt.innerHTML = html;
    return txt.value;
}

function shuffleArray(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
}

async function fetchQuestions() {
    const category = categorySelect.value;
    const difficulty = difficultySelect.value;
    let amount;
    if (difficulty === "easy") {
        amount = 10;
    } else if (difficulty === "medium") {
        amount = 15;
    } else if (difficulty === "hard") {
        amount = 20;
    }
    
    const url = `https://opentdb.com/api.php?amount=${amount}&category=${category}&difficulty=${difficulty}&type=multiple`;
    
    try {
        const response = await fetch(url);
        const data = await response.json();
        
        if (data.response_code === 0) {
            return data.results.map(question => {
                return {
                    question: decodeHTML(question.question),
                    correctAnswer: decodeHTML(question.correct_answer),
                    options: shuffleArray([
                        ...question.incorrect_answers.map(answer => decodeHTML(answer)),
                        decodeHTML(question.correct_answer)
                    ])
                };
            });
        } else {
            throw new Error('Failed to fetch questions');
        }
    } catch (error) {
        console.error('Error fetching questions:', error);
        alert('Failed to fetch questions. Please try again.');
        return [];
    }
}

async function startGame() {
    startScreen.classList.add('hidden');
    loadingScreen.classList.remove('hidden');

    currentQuestionIndex = 0;
    score = 0;
    scoreElement.textContent = score;
    
    questions = await fetchQuestions();
    
    if (questions.length === 0) {
        resetGame();
        return;
    }
    
    totalQuestionsElement.textContent = questions.length;
    maxScoreElement.textContent = questions.length;
    
    loadingScreen.classList.add('hidden');
    gameScreen.classList.remove('hidden');
    
    loadQuestion();
}

function loadQuestion() {
    const question = questions[currentQuestionIndex];
    currentQuestionElement.textContent = currentQuestionIndex + 1;
    
    questionText.textContent = question.question;
    
    optionsContainer.innerHTML = '';
    
    const optionLetters = ['A', 'B', 'C', 'D'];
    question.options.forEach((option, index) => {
        const optionElement = document.createElement('div');
        optionElement.classList.add('option');
        optionElement.innerHTML = `
            <span class="option-prefix">${optionLetters[index]}</span>
            <span class="option-text">${option}</span>
        `;
        optionElement.dataset.option = option;
        optionElement.addEventListener('click', checkAnswer);
        optionsContainer.appendChild(optionElement);
    });
    
    feedback.classList.add('hidden');
    
    startTimer();
}

function startTimer() {
    timeLeft = 15;
    timerText.textContent = timeLeft;
    timerBar.style.width = '100%';
    
    clearInterval(timerInterval);
    timerInterval = setInterval(() => {
        timeLeft--;
        timerText.textContent = timeLeft;
        timerBar.style.width = `${(timeLeft / 15) * 100}%`;
        
        if (timeLeft <= 0) {
            clearInterval(timerInterval);
            timeOut();
        }
    }, 1000);
}

function timeOut() {
    const options = document.querySelectorAll('.option');
    options.forEach(option => {
        option.classList.add('disabled');
        if (option.dataset.option === questions[currentQuestionIndex].correctAnswer) {
            option.classList.add('correct');
        }
    });
   
    feedbackText.textContent = `The clock ran out! The correct answer is highlighted.`;
    feedbackText.style.color = 'blue';
    feedback.classList.remove('hidden');
}

function checkAnswer(e) {
    clearInterval(timerInterval);
    
    const selectedOption = e.currentTarget;
    const selectedAnswer = selectedOption.dataset.option;
    const correctAnswer = questions[currentQuestionIndex].correctAnswer;
    const isCorrect = selectedAnswer === correctAnswer;
    
    const options = document.querySelectorAll('.option');
    options.forEach(option => {
        option.classList.add('disabled');
        if (option.dataset.option === correctAnswer) {
            option.classList.add('correct');
        }
    });
    
    if (isCorrect) {
        selectedOption.classList.add('correct');
        score++;
        scoreElement.textContent = score;
        feedbackText.textContent = "Well done! That's the correct answer.";
        feedbackText.style.color = 'green';
    } else {
        selectedOption.classList.add('incorrect');
        feedbackText.textContent = 'Incorrect! The correct answer is highlighted.';
        feedbackText.style.color = 'red';
    }
    
    feedback.classList.remove('hidden');
}

function loadNextQuestion() {
    currentQuestionIndex++;
    
    if (currentQuestionIndex < questions.length) {
        loadQuestion();
    } else {
        endGame();
    }
}

function endGame() {
    gameScreen.classList.add('hidden');
    endScreen.classList.remove('hidden');
    finalScoreElement.textContent = score;
}

function resetGame() {
    endScreen.classList.add('hidden');
    loadingScreen.classList.add('hidden');
    gameScreen.classList.add('hidden');
    startScreen.classList.remove('hidden');
}
