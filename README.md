Sky Engine v0.9.8
=================

All rights reserved to Matthew Kelly (Badgerati) and Cadaeic Studios. Usage of the Sky Engine, or any of its enclosed
components, packages, classes and/or methods much appropriately give credit to the developer (either
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

Usage of the engine is still in development. However you can now find the documentation either on here,
or over at http://badgerati.com/projects/sky_engine/ -  it still is not fully complete yet, with most
descriptions etc. missing.




Updates and Fixes
-----------------

	* Added Triangulation object, to make triangulating vertices more re-usable.
	* Added a TextureManager to allow re-use of Textures.
	* Bounding Volumes are no longer depreciated, and should be used over Geometric Shapes for collision detection.
	* Moved the SoundManager to a new package: sky.engine.audio
	* Moved the FileManager to a new package: sky.engine.io
	* Graphical Shapes are no longer called GCircle etc. and are now called DrawableCircle etc.
	* Graphical Shapes now all implement the DrawableShape interface.




Future Development and Ideas
----------------------------

	* Implement bounding volume hierarchies.
	* A class that can deal with the inbuilt Android 'options' menu more easily.
	* A class that can have more control over screens - much like in XNA.
	* Extend the HighscoreManager to deal with possibilities other than just name-and-score.
	* Multiplayer and Networking - this may have to be done across bluetooth.
	* Improve the particle engine, so we can now use sprites as particles.
	* Possibility of polygonisation instead of triangulation, to generate more efficient convex polygons for collision detection.
	* Develop the use of an event-driven architecture. This will have to be done for multiplayer.
	* XML parser, for the data sent back and forth between devices.
	* A long shot, but research into LUA for user-developed add-ons?
	* The big one. 3D and OpenGL.