let score = JSON.parse(localStorage.getItem('score')) || {
  win : 0,
  loose : 0,
  tie: 0
};

function reset(){
let resultField = document.getElementById('resultField');
score = {  
  win : 0,
  loose : 0,
  tie : 0
}
resultField.innerHTML = "Your move: -.<br> Computer Move: -.<br><br> Result: 'Play to Find' <br><br>Wins: 0; Looses: 0; Ties: 0"
localStorage.removeItem('score'); // this also removes the data from the storesge, it will not comback when refreshed
clearInterval(intervalID);
isAutoplay = false;
autoplayButton.textContent = 'Autoplay';
}

let isAutoplay = false;
let intervalID;
const autoplayButton = document.querySelector('.autoplay');

const runner = () => {
  manMove = generateRamdomMove();
  compareMoves(manMove);
}

function autoplay(){
  if(!isAutoplay){
    intervalID = setInterval(runner,1000);
    isAutoplay = true;
    autoplayButton.textContent = 'Stop Autoplay';
  }
  else{
    clearInterval(intervalID);
    isAutoplay = false;
    autoplayButton.textContent = 'Autoplay';
  }
}

function generateRamdomMove(){
  let computerMove;
  let randomNumber = Math.random();

  if(randomNumber >= 0 && randomNumber < 1/3){
    computerMove = 'Rock';
  }
  else if(randomNumber >= 1/3 && randomNumber < 2/3){
    computerMove = 'Paper';
  }
  else{
    computerMove = 'Sissor';
  }

  return computerMove;
}

function compareMoves(manMove){
  let computerMove = generateRamdomMove();
  let resultField = document.getElementById('resultField');

  if(computerMove == manMove){
    score.tie++;
    console.log(`Your move: ${manMove}. Computer Move: ${computerMove}. "Tie"
  Wins: ${score.win}; Looses: ${score.loose}; Ties: ${score.tie}`);
  //    alert(`Your move: ${manMove}. Computer Move: ${computerMove}. "Tie"
  // Wins: ${score.win}; Looses: ${score.loose}; Ties: ${score.tie}`);
    resultField.innerHTML = `Your move: ${manMove}.<br> Computer Move: ${computerMove}.<br><br> Result: 'Tie' <br><br>Wins: ${score.win}; Looses: ${score.loose}; Ties: ${score.tie}`;
  }
  else if(computerMove === 'Rock' && manMove === 'Sissor' || 
    computerMove === 'Paper' && manMove === 'Rock' ||
    computerMove === 'Sissor' && manMove === 'Paper'
  ){
    score.loose++;
    console.log(`Your move: ${manMove}. Computer Move: ${computerMove}. "You Loose"
  Wins: ${score.win}; Looses: ${score.loose}; Ties: ${score.tie}`);
  //    alert(`Your move: ${manMove}. Computer Move: ${computerMove}. "You Loose"
  // Wins: ${score.win}; Looses: ${score.loose}; Ties: ${score.tie}`);
    resultField.innerHTML = `Your move: ${manMove}.<br> Computer Move: ${computerMove}.<br><br> Result: 'You Loose' <br><br>Wins: ${score.win}; Looses: ${score.loose}; Ties: ${score.tie}`;
  }
  else{
    score.win++;
    console.log(`Your move: ${manMove}. Computer Move: ${computerMove}. "You Win!"
  Wins: ${score.win}; Looses: ${score.loose}; Ties: ${score.tie}`);
  //    alert(`Your move: ${manMove}. Computer Move: ${computerMove}. "You Win!"
  // Wins: ${score.win}; Looses: ${score.loose}; Ties: ${score.tie}`);
    resultField.innerHTML = `Your move: ${manMove}.<br> Computer Move: ${computerMove}.<br><br> Result: 'You Win!' <br><br>Wins: ${score.win}; Looses: ${score.loose}; Ties: ${score.tie}`;
  }

  localStorage.setItem('score', JSON.stringify(score));
}