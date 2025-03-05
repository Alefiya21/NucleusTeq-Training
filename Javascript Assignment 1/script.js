let totalScore, currentScore, activePlayer, playing;

const player1 = document.querySelector(".player-1");
const player2 = document.querySelector(".player-2");
const name1 = document.getElementById("name-1");
const name2 = document.getElementById("name-2");
const score1 = document.getElementById("score-0");
const score2 = document.getElementById("score-1");
const current1 = document.getElementById("current-0");
const current2 = document.getElementById("current-1");
const diceEl = document.getElementById("dice");
const btnRollDice = document.getElementById("roll-dice");
const btnSaveScore = document.getElementById("save-score");
const btnReset = document.getElementById("reset-game");
const btnPlayAgain = document.getElementById("play-again");
const winnerModal = document.getElementById("winner-modal");
const winnerMessage = document.getElementById("winner-message");

const winningScore = 100;

document.querySelectorAll(".name").forEach((player) => {
  player.addEventListener("click", () => {
    if (playing) {
      const newName = prompt("Enter new name:", player.textContent);
      if (newName !== null && newName.trim() !== "") {
        player.textContent = newName;
      }
    }
  });
});

const init = () => {
  totalScore = [0, 0];
  currentScore = 0;
  activePlayer = 0;
  playing = true;

  diceEl.style.backgroundImage = "url('images/dice1.png')";
  
  score1.textContent = 0;
  score2.textContent = 0;
  current1.textContent = 0;
  current2.textContent = 0;

  player1.classList.add("player-active");
  player2.classList.remove("player-active");
  winnerModal.style.display = "none";

  name1.disabled = true;
  name2.disabled = true;

  setTimeout(() => {
    alert("Click on a player's name to change it.");
  }, 500);
};

const renderDice = (dice) => {
  diceEl.classList.add("dice-rolling");
  setTimeout(() => {
    diceEl.style.backgroundImage = `url('images/dice${dice}.png')`;
    diceEl.classList.remove("dice-rolling");
  }, 400); 
};

const switchPlayer = () => {
  document.getElementById(`current-${activePlayer}`).textContent = 0;
  currentScore = 0;
  activePlayer = activePlayer === 0 ? 1 : 0;
  player1.classList.toggle("player-active");
  player2.classList.toggle("player-active");
};

btnRollDice.addEventListener("click", () => {
  if (playing) {
    const dice = Math.trunc(Math.random() * 6) + 1;

    renderDice(dice);

    if (dice !== 1) {
      currentScore += dice;
      document.getElementById(`current-${activePlayer}`).textContent = currentScore;
    } else {
      setTimeout(switchPlayer, 400);
    }
  }
});

btnSaveScore.addEventListener("click", () => {
  if (playing) {
    totalScore[activePlayer] += currentScore;
    document.getElementById(`score-${activePlayer}`).textContent = totalScore[activePlayer];

    if (totalScore[activePlayer] < winningScore) {
      switchPlayer();
    } else {
      playing = false;
      const winnerName = document.getElementById(`name-${activePlayer + 1}`).textContent;
      winnerMessage.textContent = `${winnerName} wins!`;
      winnerModal.style.display = "block";
    }
  }
});

btnReset.addEventListener("click", init);

btnPlayAgain.addEventListener("click", () => {
  location.reload();
});

init();
