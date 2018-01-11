==================== SERVER =======================

while(true){
  long start = System.currentTimeInMillis();
  update();
  long time = 500 - (System.currentTimeInMillis() - start)
  Thread.sleep(time);
}

update(){
  moves = pairs(Player, Move)
  for(Player p : players){
    move = p.sendState(board)
    moves.add(p, move)
  }
  moves.shuffle()
  for(Player p, Move m : moves){
    board.move(p, move)
  }
}


NetworkPlayer {
  getMove(){
    connection.getMove();
  }

  sendState(){
    connection.send(state)
  }
}

Board {
  int[][] board;

  sychronized move(snake, where){
    snake.move(board, where)
  }
}


===================== CLIENT =======================

while(true){
  state = socket.read()
  p.applyState(state)
  socker.send(p.getMove())
}

LocalPlayer {
  getMove(){
    getPressedKey()
  }

  applyState(state){
    gui.display(state);
  }
}
