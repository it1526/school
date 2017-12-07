/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Hand.h
 * Author: Vikto
 *
 * Created on 11. října 2017, 18:27
 */
#include <vector>
#include <string>
#include "Card.h"


#ifndef HAND_H
#define HAND_H

typedef enum{
    STANDARD,SOFT,BUST,BLACKJACK
}State;

class Hand {
public:
    Hand();
    Hand(const Hand& orig);
    
    int getBet() const;
    void setBet();
    
    int getValue() const;
    int getSoftValue() const;
    State getState() const;
    int getSize() const;
    const Card& getCardAt(int) const;
    const Card& operator [] (int) const;    
    std::string getValueString() const;
    
    
    bool isBust() const;
    bool isSplittable() const;
    bool isSoft() const;
    bool isBlackjack() const;
    
    void drop();
    Card popCard();
    void pushCard(Card card);
    
    virtual ~Hand();
private:
    std::vector<Card> cards;
    int bet;
};

#endif /* HAND_H */

