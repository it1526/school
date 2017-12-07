/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Hand.cpp
 * Author: Vikto
 * 
 * Created on 11. října 2017, 18:27
 */

#include "Hand.h"

Hand::Hand() {
}

void Hand::drop(){
    int i;
    for(i=0;i<this->cards.size();i++)
        this->cards[i].~Card();
    this->cards.clear();
    return;
}

void Hand::pushCard(Card card){
    this->cards.push_back(card);
}

Card Hand::popCard(){
    Card card = this->cards.back();
    cards.pop_back();
    return card;
    
}

State Hand::getState() const{
    if(this->isBlackjack())
        return BLACKJACK;
    else if(this->isSoft())
        return SOFT;
    else if(this->isBust())
        return BUST;
    else
        return STANDARD;
}

const Card& Hand::getCardAt(int card) const{
    return this->cards[card];
}

const Card& Hand::operator [] (int card) const{
    return this->cards[card];
}

int Hand::getSize() const{
    return this->cards.size();
}

int Hand::getValue() const{
    int sum = 0;
    for(Card card:this->cards){
        sum += card.getGameValue();
    }
    return sum;
}


bool Hand::isBlackjack() const{
    if(this->cards.size() == 2 && this->isSoft() && this->getValue() == 11)
        return true;
    else
        return false;
}

bool Hand::isBust() const{
    if (this->getValue() > 21)
        return true;
    else
        return false;
}

bool Hand::isSoft() const{
    bool soft = false;
    if(this->getValue() + 10 > 21)
        return false;
    for(Card card:this->cards)
        if (card.isSoft())
            soft = true;
    return soft;    
}

std::string Hand::getValueString(){
    std::string value;
    value += std::to_string(this->getValue());
    if(this->isSoft()){
        value += "/";
        value += std::to_string(this->getSoftValue());
    }
    return value;
    
}

int Hand::getSoftValue() const{
    if(this->isSoft())
        return this->getValue()+10;
    return -1;
}

bool Hand::isSplittable() const{
    if(this->cards.size() == 2 && this->cards[0].getGameValue() == this->cards[1].getGameValue())
        return true;
    else
        return false;
}

int Hand::getBet() const{
    return this->bet;
}

void Hand::setBet(int bet){
    this->bet = bet;
}

Hand::Hand(const Hand& orig) {
}

Hand::~Hand() {
}

