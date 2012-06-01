Sky Engine v0.9.5
=================

All rights reserved to Matthew Kelly (Badgerati) and Cadaeic Studios. Usage of the Sky Engine, or any of its enclosed
components, packages, classes and/or methods much appropriately give credit to the developer. (Either
'Matthew Kelly (Badgerati)' or 'Cadaeic Studios').

Sky Engine is a basic 2D Games Engine for use with Android Development, programmed in Java. It is still
currently under development, but a lot of the engine exists to be able to create basic games.

The Engine utilises the Android Canvas to draw shapes, sprites and text to the screen.

Sky Engine has been designed to have an almost XNA feel and approach, where after initially
creating the thread and surfaces with the main Activity itself; all game functions are
placed in a class that should implement StageInterface. This brings forth methods such as:

	* load
	* handleInput
	* update
	* draw
	
(Which may look familiar if you have used XNA before).




Documentation and Usage
-----------------------

This is all still fairly under construction at the moment.

There is a basic JavaDoc, which can be found in the doc/index.html file. It is not fully complete
yet, with most descriptions etc. missing.




Further Development
-------------------

	* Improved triangulation.
	* Multiplayer and Networking (as well as Bluetooth Connectivity).
	* 3D with OpenGL.