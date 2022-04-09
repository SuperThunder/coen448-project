package com.coen448;

public enum UserCommand {
    Move, //M s
    Left, //L
    Right, //R
    PrintGrid, //P
    Stop, //Q
    Up, //U
    Down, //D
    PrintPen, //C
    Initialize, //I
    Replay, //H
    Unknown, //For case of user entering invalid command
    Invalid //For case of user entering valid command but invalid parameter
}
