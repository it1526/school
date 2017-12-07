/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Player.h
 * Author: Vikto
 *
 * Created on 12. října 2017, 17:15
 */

#include <vector>
#include "Hand.h"

#ifndef PLAYER_H
#define PLAYER_H

class Player {
public:
    Player();
    Player(int);
    Player(const Player& orig);
    
    void winBet();
    void setBet();
    
    bool isActive() const;
    void setActive(bool);
    int getAccount() const;
    int getNumberOfHands() const;
    const Hand& getHandAt(int) const;
    const Hand& getPlayingHand() const;
    const Hand& operator [](int) const;
    
    void reset();
    void drop();
    
    void hit();
    void stand();
    void double_b();
    void split();
    void surrender();
    
    bool canSplit() const;
    bool canDouble() const;
    bool canSurrender() const;
    
    int getValidChoices() const;
    
    virtual ~Player();
private:
    std::vector<Hand> hands;
    int playingHand;
    int account;
    bool active;
    bool hasSurrendered;
};

#endif /* PLAYER_H */

