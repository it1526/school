/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Blackjack.h
 * Author: Vikto
 *
 * Created on 12. října 2017, 17:09
 */
#include "Hand.h"
#include "Card.h"
#include "Player.h"
#include <vector>

#ifndef BLACKJACK_H
#define BLACKJACK_H

typedef enum{
    Hit= 0b1,Stand = 0b10,Double = 0b100,Split=0b1000,Surrender=0b100000
}Choice;

class Blackjack {
public:
    Blackjack();
    Blackjack(int,int,int,int,int,float,bool);
    Blackjack(const Blackjack& orig);
    
    void game();
    
    virtual ~Blackjack();
private:
    void shuffle();
    void reset();
    int inputInt(int,int,char*);
    bool vycistitBuffer();
    char inputChar();
    Choice getChoice(int);
    void printPlayingState() const;
    void printBettingState() const;
    bool dealerAI();
    
    std::vector<Player> players;
    std::vector<Card> shoe;
    Hand dealer;
    int shoeSize;
    bool hitSoft17;
    int min;
    int max;
    float shufflePercent;
};

#endif /* BLACKJACK_H */