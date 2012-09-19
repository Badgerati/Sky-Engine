Sky Engine v0.9.4
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

Version 0.9.4

	* Implemented a Randomiser abstract class, for better and further functionality on random numbers.
	* Implemented a Timer class. It's now far easier to have a timer for a game, or certain events. Something I've been meaning to add for a long time.
	* Timers can be started, reset, stopped, paused and resumed. To get current time, call getTime() method, this will return time in seconds to some degree of milliseconds as a float.
	* Added quite a lot more colours, including pink.
	* Fixed the Particle Trail class to be able to have its position updated. How did I miss that? Sigh.
	* Implemented a LinearGradient class. This is different from Android's, such that you can also call draw(Canvas) on the gradient.
	* Added a few more Styles.
	* Implemented new FileAssetManager class. This is useful for reading text files from your game's "asset" folder. It extends FileManager.
	* This is one is awesome: Implemented ScoreCounter class. This takes a value, adds it to a max score, and then gradually increments the actual score till it reaches the max score. Can also decrement as well.
	* StageCreator now publically stores the "screencentre" and "screenscale". The scale is based from a default size of (854, 480, 0).
	* StageCreator also now has a load(Size screensize) method. This is what stores the true screen size, the cenre and the scale.
	* StageCreator also implements pause() and resume() methods, as well as StageLoop.
	* CustomText and Text now centre text far better.
	* Added a FadingText class, where text fades in, then fades out, and repeat. You can set the timers/speed of each fade.
	* Added a FlashingText class. This is similar to above, put does not contain fading.
	* Added a SlidingText class. This is where text is put into a 'window' and slides across, a bt like LED Displays with text scrolling horizontally on them.
	* Added a SpinningText class. Here, text spins/rotates around it's centre, or a given point.
	* PauseButton is now a base abstract class, wih extensions from BoxPauseButton and CirclePauseButton.
	* Implemented a MessageDialog class. Quite simply, it's a box, with a message really. More of a TextDialog really, as it has no buttons for 'OK' etc. So don't confuse with MicroSoft MessageBox.
	* Added SEArrayList class, which extends ArrayList class. This adds funcionality like randomising the elements, or returning an array of so many random elements.


Version 0.9.3

	* Added primitive user-interface controls, for now just Buttons.
	* Extending Buttons is a basic PauseButton control, which displays the button, and a message on pause.
	* Added GameoverDialog to display scores, retries and quit.
	* Implemented Options class, to store, read, set and save various options within a game. They're stored using a basic HashMap<String, String>.
	* Added Styles to the Engine (at last). These contain preset Fill, Outline and Blur settings for different styles. For now, just for normal/focused settings, but will extend for text.
	* SoundManager is now abstract; I don't know why it wasn't before. This means sounds can be accessed from anywhere with a game - much better.
	* GameActivity now implements a basic FrameLayout, in case we wish to use actual Android UI features from an XML file.
	* OnPause in GameActivity has been altered to reflect the PauseButton in StageCreator. If one exists, it defaults to use the Button, otherwise acts like normal.
	* Pause screen now also contains a "retry" feature, as well as "continue" and "quit".
	* Fixed an error within the Circle class where the circumference was being calculated incorrectly.
	* the GeometricShape interface has now been renamed to the better suited CollidableBody. It has also been moved to 'sky.engine.physics.bodies', along side "RigidBody" class.
	* Collision detection now also works on just Points.
	* The BoundingBox now directly extends Bounding, instead of through BoundingPoly.
	* Added a new BoundingArc and BoundingOval classes.
	* DrawableShape classes now implement better "colouring" features, that can utilise the inbuilt Styles.
	* Shapes now also have show() and hide() methods.
	* Fixed some issues with the AnimatedSprite class, including the "firstframe" confusion variable. This has now been removed.
	* Sprite is now better intergrated with scaling functionality.
	* Sprite has an inbuild bounding volume of a BoundingOval called "spriteBound". It's there for mild convenience, but not neccassary.
	* StageCreator now stores the GameThread, Activity, Surface and Context for better convenience.
	* GameSurface now also stores the centre point of the screen in "ScreenCentre" variable.
	* Implemented a FontManager abstract class for loading fonts into a game, and for access anywhere.
	* The Circumcircle class has now been better integrated into other classes (Shapes and Boundings).


Version 0.9.2

	* Modified Box and DrawableBox. They not longer extends Polygon, and can only be constructed by width and height.
	* Added new Quad and DrawableQuad to replace the vertex construction of the old Box/DrawableBox.
	* Added new DrawablePoint to draw a point (pixel) to the screen.
	* Renamed Vector2D and Vector3D to Vector2 and Vector3, respectively.
	* Added new Circumcircle class to help generate the smallest bounding circle around a given point-set. Algorithm is my own.
	* Added new Text and CustomText classes. Currently they don't do much apart from allow quicker re-usable text. (Text may get removed later on, so use CustomText for now).
	* Added new Fill, Outline and Blur paint objects to help with easier drawable shape constructions.
	* All drawable shapes now allow for a blur effect - a sort of slight glowing around the edges of the shapes.


Version 0.9.1

	* All drawable shapes in the graphics package have been moved to: sky.engine.graphics.drawable
	* Sprites and Particles packages have also been move to: sky.engine.graphics.drawable
	* Angle class has been moved to: sky.engine.math from sky.engine.geometry
	* Added new geometric shapes: Arc and Oval.
	* Added new drawable shapes: DrawableArc, DrawableOval, DrawableRoundedBox, and DrawableRoundBox2.
	* Added a GameActivity class to make creating the main game views far simpler, for reuse of Pause, OnCreate etc.
	* Added a StageCreator class to make creating stages far simpler, for reuse of threads, contexts, and texture managers etc.
	* Sizes are now comparable.
	* Changed the static final of Vector.Zeros to a method instead - since it was erroring.
	* Created new GeometricShapes interface to help with collision resolutions - such as project() and getAxes().
	* Vectors have now been moved to their own package: sky.engine.geometry.vectors


Version 0.9.0

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
	

Version 0.8.0

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