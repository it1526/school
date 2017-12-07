/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Blackjack.cpp
 * Author: Vikto
 * 
 * Created on 12. října 2017, 17:09
 */

#include "Blackjack.h"
#include "Hand.h"
#include "Player.h"
#include <algorithm>
#include <iostream>
#include "Card.h"

Blackjack::Blackjack() {
}

Blackjack::Blackjack(int players, int shoeSize, int min, int max, bool hitSoft17){
    this->shoeSize = shoeSize;
    this->min = min;
    this->max = max;
    this->hitSoft17 = hitSoft17;
    this->shuffle();
}

Blackjack::Blackjack(const Blackjack& orig) {
}

void Blackjack::game(){
    std::cout << "Vitejte v BlackJacku";
    
    do{
        this->reset();
        
        for(Player player : players){
            
        }
        for(Player player : players){
            do{
                printPlayingState(player);
                Choice playersChoice = getChoice(player.getValidChoices());
                switch(playersChoice){
                    case Hit:
                        player.hit();
                        break;
                    case Stand:
                        player.stand();
                        break;
                    case Split:
                        player.split();
                        break;
                    case Double:
                        player.double_b();
                        break;
                    case Surrender:
                        player.surrender();
                        break;
                }
                
            }while(player.isActive());
        }
        std::cout << "Chcete ukonict hru?\n";
    }while(this->inputChar() != 'y');
}

bool Blackjack::vycistitBuffer(){
    bool neplatnyVstup = false;
    
    while(getchar() != '\n'){
        neplatnyVstup = true;
    }
    return neplatnyVstup;
}

Choice Blackjack::getChoice(int validChoices){
    char choice;
    
    while(true){
        std::cout << "Zadejte Vasi volbu: ";
        choice = inputChar();
        if(                                     choice == 'h' || choice == 'H')
            return Hit;
        else if(                                choice == 's' || choice == 'S')
            return Stand;
        else if( (Split & validChoices)     && (choice == 'p' || choice == 'P') )
            return Split;
        else if( (Double & validChoices)    && (choice == 'd' || choice == 'D') )
            return Double;
        else if( (Surrender & validChoices) && (choice == 'r' || choice == 'R'))
            return Surrender;
        else
            std::cout << "Neplatna volba!\n";
    }
}

void Blackjack::printPlayingState(const Player& player) const{
    std::cout << "Vase konto: " << player.getAccount();
    
    std::cout << "\n Dealer: " << Card::setChar[dealer[0].getSet()] << dealer[0].getValue() << " ??\n\n";
    int i = 1;
    for(Player playerDisplay : this->players){
        std::cout << "Hrac " << i << ":\n";
        for(const Hand& hand : playerDisplay){
            for(const Card& card : hand){
                std::cout << Card::setChar[card.getSet()] << card.getValue() << " ";
            }
            std::cout << " | " << hand.getValueString();
            if (hand == playerDisplay.getPlayingHand())
                std::cout << " <<<";
            std::cout << "\n";
        }
        i++;
    }

    std::cout << "H - Hit\nS - Stand\n";
    if(player.canSplit())
        std::cout << "P - Split\n";
    if(player.canDouble())
        std::cout << "D - Double\n";
    if(player.canSurrender())
        std::cout << "R - Surrender\n";
}

char Blackjack::inputChar(){
    char vstup;
    int neplatnyVstup;
    
    while(1){
        printf("Vstup: ");
        scanf("%c",vstup);
        if (!vycistitBuffer())
            return vstup;
        printf("Neplatny vstup\n");
    }
}

int Blackjack::inputInt(int min,int max, char* text){
    int volba;
    int neplatnyVstup;
    
    while(1){
        if (min == 1)
            printf("%s <Max %d>: ",text,max);
        else
            printf("%s <%d - %d>: ",text,min,max);
        scanf("%d",&volba);
        neplatnyVstup = this->vycistitBuffer();
        if (volba > 0 && volba <= max && neplatnyVstup == 0)
            return volba;
        else if (neplatnyVstup != 0)
            printf("Neplatny vstup!\n");
        else
            printf("Mimo rozsah!\n");
    }
}

void Blackjack::reset(){
    int i;
    if(this->shoe.size() / (this->shoeSize*52 <= this->shufflePercent)){
        this->shuffle();
        std::cout << "Shuffling!\n";
    }
    this->dealer.drop();
    for(i=0;i<players.size();i++)
        players[i].reset();
}

void Blackjack::shuffle(){
    int i,a,b;
    Card cache;
    
    for(Card card:this->shoe)
        card.~card();
    this->shoe.clear();
    
    for(i=0;i<this->shoeSize;i++)
        for(a=1;a<=13;a++)
            for(b=0;b<4;b++)
                this->shoe.emplace_back(a,b);
    std::random_shuffle(this->shoe.begin(),this->shoe.end());
}

void Blackjack::dealerAI(){
    
}

Blackjack::~Blackjack() {
}

