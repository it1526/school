/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Player.cpp
 * Author: Vikto
 * 
 * Created on 12. října 2017, 17:15
 */

#include "Player.h"

Player::Player() {
    this->account = 500;
    this->playingHand = 0;
    this->active = true;
    this->hasSurrendered = false;
}

Player::Player(int account){
    this->account = account;
    this->playingHand = 0;
    this->active = true;
    this->hasSurrendered = false;
}

int Player::getAccount() const{
    return this->account;
}

const Hand& Player::getHandAt(int hand) const{
    return this->hands[hand];
}

const Hand& Player::getPlayingHand() const{
    return this->hands[playingHand];
}

const Hand& Player::operator[] (int hand) const{
    return this->hands[hand];
}

int Player::getNumberOfHands() const{
    return this->hands.size();
}

void Player::reset(){
    this->active = true;
    this->drop();
}

void Player::drop(){
    for(Hand hand : hands){
        hand.drop();
        hand.~Hand();
    }
    this->hands.clear();
}

bool Player::isActive() const{
    return this->active;
}

void Player::setActive(bool active){
    this->active = active;
}

void Player::hit(){
    this->hands[playingHand].pushCard(/* STACK */);
    if (this->hands[playingHand].getState() == BUST || this->hands[playingHand].getValue() == 21 || this->hands[playingHand].getSoftValue() == 21)
        this->stand();
}

void Player::stand(){
    this->playingHand++;
    if (playingHand >= this->hands.size())
        this->active = false;
}

void Player::split(){
    Hand hand();
    hand.pushCard(hands[playingHand].popCard());
    this->hands[playingHand].pushCard(/* STACK */);
    this->hands.push_back(hand);
}

void Player::double_b(){
    this->hands[playingHand].pushCard(/* STACK */);
    this->stand();
    this->account -= this->hands[playingHand].getBet();
    this->hands[playingHand].setBet() = 2*this->hands[playingHand].getBet();
    
}

void Player::surrender(){
    this->account += this->hands[0].getBet() / 2;
    this->hasSurrendered = true;
    this->active = false;
}

bool Player::canSplit() const{
    if (hands[playingHand].isSplittable() && this->account >= hands[playingHand].getBet())
        return true;
    else
        return false;
}

bool Player::canDouble() const{
    if (hands[playingHand].getSize() == 2 && this->account >= hands[playingHand].getBet())
        return true;
    else
        return false;
}

bool Player::canSurrender() const{
    if (this->playingHand == 0 && this->hands[0].getSize() == 2)
        return true;
    else
        return false;
}

int Player::getValidChoices() const{
    int validChoices = (Hit | Stand);
    if(canSplit())
        validChoices |= Split;
    if(canDouble())
        validChoices |= Double;
    if(canSurrender())
        validChoices |= Surrender;
    return validChoices;
    
}

Player::Player(const Player& orig) {
}

Player::~Player() {
}