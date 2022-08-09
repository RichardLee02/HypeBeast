# HypeBeast 

## About 

**What Will The Application Do?**

**HypeBeast** is an application to keep track of fashionable items, mainly clothing and shoes. Users of **HypeBeast**
will be able to add clothing/shoes into their collection, while also being able to remove it. **HypeBeast** also
includes other features such as viewing all of your items and viewing the number of pieces in your collection.

**Who Will Use It?**

As the streetwear market is growing exponentially and more people are getting involved in reselling, **HypeBeast** will 
provide resellers a way to keep track of their items in a collection. Rather than keeping record of their pieces by 
visual, **HypeBeast** is a simple application that enables people to keep a digital record of their inventory.

**Why Is This Project Of Interest To You?**

As a streetwear collector and reseller myself, the most irritating thing is losing track of my collection. However,
with **HypeBeast**, it provides a way of recording all of my pieces - I will be able to have a list of clothing/shoes 
with information including its brand, model, size, and many more.

## User Stories 

**Phase 1:**

- As a user, I want to be able to add clothing/shoes to my collection
- As a user, I want to be able to remove clothing/shoes in my collection
- As a user, I want to be able to view clothing/shoes in my collection
- As a user, I want to be able to view the number of clothing/shoes in my collection

**Phase 2:**

- As a user, I want to be able to save my collection to file
- As a user, I want to be able to load my collection from file

**Phase 4: Task 2**

A representation sample of the events that occur when HypeBeast GUI runs:

- Mon Mar 28 22:29:48 PDT 2022
  - Added Clothing: [Brand = 'Essentials', Model = 'Black Pullover Hoodie', 
    Condition = 'NWT', Size = 'M', Bought Price = '150', Market Price = '300']
- Mon Mar 28 22:30:28 PDT 2022 
  - Added Shoes: [Brand = 'Nike', Model = 'Air Force 1 Low Travis Scott Sail', 
    Condition = 'DS', Size = '10', Bought Price = '150', Market Price = '300']
- Mon Mar 28 22:30:30 PDT 2022
  - Removed Clothing: [Brand = 'Essentials', Model = 'Black Pullover Hoodie', 
    Condition = 'NWT', Size = 'M', Bought Price = '150', Market Price = '300']
- Mon Mar 28 22:30:32 PDT 2022
  - Removed Shoes: [Brand = 'Nike', Model = 'Air Force 1 Low Travis Scott Sail', 
    Condition = 'DS', Size = '10', Bought Price = '150', Market Price = '300']

**Phase 4: Task 3**

If I had more time to work on the project, the changes that I would make to improve the design includes:
- Improving cohesion by having more classes, such that every class is responsible for one thing
  - While the design of the classes Clothing and Shoes adheres accordingly, HypeBeastApplication and HypeBeastGUI have 
    methods that can be refactored into different classes 
- Reducing moderate and semantic coupling, such that a change in one class will not cause a bug or compile error in the 
  other class 
  - By adhering to the Single Point of Control, it is best to make a change in only one place
- Having helper methods to decrease duplicated code and to improve readability   
  - HypeBeastApplication and HypeBeastGUI have code that can be refactored into helper methods to shorten and reduce 
    error in code by having only one placement 



