# Car-Configuration-Application
This project is used to build a car configuration application:

Please first start the server by running the driver class in the server project, and then use client to upload properties files by running the driver class in the client project. Next, start the servlet by running ModelList.java.

###Server

	package server:
		1) AutoServer.java - Interface
		2) BuildCarModelOptions.java - Build car models
		3) DefaultSocketClient.java - Default client socket
		4) SocketClientConstants.java - Interface
		5) SocketClientInterface.java - Interface

	package model:
		1) Automobile.java - Including the public Automotive class representing the models.
		2) OptionSet.java - Including the OptionSet class representing the option sets, and the inner class Option representing the options.

	package adapter:
		1) BuildAuto.java - Used externally to build auto
		2) CreateAuto.java - Interface
		3) UpdateAuto.java - Interface
		4) EditThread.java - Interface
		5) FixAuto.java - Interface
		6) ProxyAutomobile.java - Abstract class including methods implementations.

	package scale:
		1) EditOptions.java - thread class used to edit options

	package exception:
		1) AutoException.java - Auto exception
		2) Fix1to6.java - Fix helper
		3) Fix7to8.java - Fix helper

	package util:
		1) FileIO.java - Used for file I/O, which can build an automotive from a text file, and do serialization and deserialization.

	package driver:	
		1) Driver.java - Main driver for the server.

	Please start from the Driver class.

###Servlet

	package client:
		1) CarModelOptionsIO.java - Used for Car IO operations
		2) SelectCarOption.java - Used for configure the car
		3) DefaultSocketClient.java - Default client socket
		4) SocketClientConstants.java - Interface
		5) SocketClientInterface.java - Interface

	package servlet:
		1) ModelList.java - Servlet used for listing the models
		2) ModelOptions.java - Servlet used for configuring the automobile

	package model:
		1) Automobile.java - Including the public Automobile class representing the models.
		2) OptionSet.java - Including the OptionSet class representing the option sets, and the inner class Option representing the options.

	package adapter:
		1) BuildAuto.java - Used externally to build auto
		2) CreateAuto.java - Interface
		3) UpdateAuto.java - Interface
		4) EditThread.java - Interface
		5) FixAuto.java - Interface
		6) ProxyAutomobile.java - Abstract class including methods implementations.

	package scale:
		1) EditOptions.java - thread class used to edit options

	package exception:
		1) AutoException.java - Auto exception
		2) Fix1to6.java - Fix helper
		3) Fix7to8.java - Fix helper

	package util:
		1) FileIO.java - Used for file I/O, which can build an automotive from a text file, and do serialization and deserialization.

	package driver:	
		1) Driver.java - Main driver for the client.

	WebContent:
		1) show.jsp - JSP file which prints the selected choices
		2) show.css - CSS file for the table styles

	BMW.properties - properties file
	Focus.properties - properties file
	Toyota.properties - properties file
	Toyota2.properties - properties file

