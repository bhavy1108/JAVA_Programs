----------------------------------------------------------------------------------
Name: SEENARAIN BHAVYATTAA
ID: 19871253
Date: 04/11/2020
COMP1002 DSA ASSIGNMENT -CryptoGraph
Curtin University
----------------------------------------------------------------------------------
THIS ASSIGNMENT FOLDER CONSISTS OF:
1.TradeDetails.java: 

This class represents trade details such as symbols, baseAsset, quoteAsset , bid and volume
It is used both as "nodes" for the LinkedList Class 
and "vertices" for Graph Class

2.LinkedList.java:

ILinkedList uses TradeDetails objects as ‘nodes’ . So , a linked list  object can be linked list of TradeDetails objects.
An extension of practical 4 has been used with some modification according the assignment specification

3.Graph.java:

Graph uses linked list object to create graph and also implement serialisable

4.CryptoGraph.java:

CryptoGraph is the main framework of the program. It uses the Graph object known as cryptograph where values which have been extracted are save to graph .However , in whole this class uses the method of linked list , Graph , Edge, GraphVertex, TradeDetails and cryptograph class itself.

5.GraphVertex.java:

GraphVertex uses as an object in Graph class and it also implement serialisable
 
6.Edge.java:

Edge class methods are used in Graph class and it also provide method getfrom(), getDest() and getNames() to cryptoGraph class
Edge class also implements serialisable

7. Queue.java:

Queue class makes use of linked list , and its functions are used in cryptoGraph class.
It also implement serialisable.

8.assetFile.json:

The asset file name that is used load asset data and display graph.

9.TradeInfo.json:

The trade file name used to load trade data and display graph.


10.Documentation, Report and CoverSheet

Documentation - all further clarifications on implementation and design
Report- Methodology and Results
CoverSheet- Declaration of Originality
----------------------------------------------------------------------------------
INFORMATION ON HOW TO RUN THE PROGRAM

First make sure that all the .java classes are well in the folder and use:
<javac -cp .:json-20200518.jar *.java> at command line to compile all
This program can be run in two modes

1.report mode 
<java -cp .:json-20200518.jar CryptoGraph -r assetFile.json TradeInfo.json>

2.interactive mode
<java -cp .:json-20200518.jar CryptoGraph -i > 

----------------------------------------------------------------------------------
