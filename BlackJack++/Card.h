/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Card.h
 * Author: Vikto
 *
 * Created on 8. října 2017, 18:56
 */

#ifndef CARD_H
#define CARD_H
typedef enum{
    CLUBS,DIAMONDS,HEARTS,SPADES
}Set;

class Card {
public:
    Card();
    Card(int,Set);
    Card(const Card& orig);
    int getValue() const;
    Set getSet() const;
    int getGameValue() const;
    bool isSoft() const;
    
    virtual ~Card();
    
    constexpr static const char setChar[4] = {'C','D','H','S'};
private:
    const int value;
    const Set set;
};

#endif /* CARD_H */

