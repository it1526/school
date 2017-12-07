/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Card.cpp
 * Author: Vikto
 * 
 * Created on 8. října 2017, 18:56
 */

#include "Card.h"

Card::Card() {
    this->value = -1;
    this->set = -1;
}

Card::Card(int value,Set set) {
    this->value = value;
    this->set = set;
}

Set Card::getSet() const{
    return this->set;
}

int Card::getValue() const{
    return this->value;
}

int Card::getGameValue() const{
    if(this->value < 10)
        return this->value;
    else
        return 10;
}

bool Card::isSoft() const{
    if (this->value == 1)
        return true;
    else
        return false;
}

Card::Card(const Card& orig) {
}

Card::~Card() {
}

