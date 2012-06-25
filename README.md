Sky Engine v0.9.9.5
===================

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

Version 0.9.9.5

	* All drawable shapes in the graphics package have been moved to: sky.engine.graphics.drawable
	* Sprites and Particles packages have also been move to: sky.engine.graphics.drawable
	* Angle class has been moved to: sky.engine.math from sky.engine.geometry
	* Added new geometric shapes: Arc and Oval.
	* Added new drawabl shapes: DrawableArc, DrawableOval, and DrawableRoundedBox.
	* Added a GameActivity class to make creating the main game views far simpler, for reuse of Pause, OnCreate etc.
	* Added a StageCreator class to make creating stages far simpler, for reuse of threads, contexts etc.


Version 0.9.9

	* Added ConvexHull class, for generating a polygon's convex hull. Uses the QuickHull algorithm.
	* Bounding Volumes have now been moved to a new package: sky.engine.graphics.bounds
	* Vectors now extends the Vector object, making things a little simplier for later ideas.
	* Vectors are now comparable, to allow the SortedArray to work correctly. (shall do same with other classes later on)
	* TextureManager is no longer abstract. Why I made it abstract originally, who knows.
	* Added new SortedArray data structure to help with geometric calculations.
	* Added new MultiList data structure. This will take a while to explain, but think arrays in PHP.
	* Added new ListSet data structure, keeping elements in the order they were added for a Set.
	* Created an Arrays class to add further functionality on arrays - such as reversing, merging and swapping.
	* You will notice a graphs package in util - this is just me dabbling around with something.
	* Graphs package works for basic graph-theory.
	* Implemented an 'ObjectMap' some simplify initialisations and settings of general HashMaps. (`HashMap<Obj, Obj>`).
	

Version 0.9.8

	* Added Triangulation object, to make triangulating vertices more re-usable.
	* Added a TextureManager to allow re-use of Textures.
	* Bounding Volumes are no longer depreciated, and should be used over Geometric Shapes for collision detection.
	* Moved the SoundManager to a new package: sky.engine.audio
	* Moved the FileManager to a new package: sky.engine.io
	* Graphical Shapes are no longer called GCircle etc. and are now called DrawableCircle etc.
	* Graphical Shapes now all implement the DrawableShape interface.




Future Development and Ideas
----------------------------

	* Implement bounding volume hierarchies (and R-trees?).
	* Implement Quaternions for use with 3D later on. Possible applications with 2D?
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