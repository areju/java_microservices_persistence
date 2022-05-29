## Prerequsites

Install MYSQL community server version 8.x along with tools and workbench

Run the following commands 
===========================

mvn clean install

## Description
===============

A small utility project that explains how to create a JPA project from scratch, mainly intended for beginners. 

Project has three important domain models

# Message
==========
    Message domain model is very simple model, which is used to gain knowledge on the following common tasks
        
        a) How to set up a persistent unit (creating a persistence.xml) 
        b) How to connect to a data source (here mysql)
        c) How EntityMangerFactory, EntityManager and transaction work
        d) checking hibernate feature "dirty" for updates
        e) creating a unit test case which covers above mentioned topic

# Item and Bid
==============

    Think of auction, an Item has a name can be auctioned on a future date which can recieve zero or more bids. Where bid is place on the item, many bids can be placed on an Item. This scenario captures ManyToOne and OneToMany mapping.

        a) Use of annotations for id, ManyToOne and OneToMany field annnotations
        b) How to avoid unnecesary updates by returning a copy of object 
        c) How to maintain bidirectional mapping
        d) Valdiating the domain models using hiberante validator

