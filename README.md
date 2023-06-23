# Android Sports Record Keeper App
<img src="ExampleScreenshots/record_keeper_example_1.jpg" height="500"><img src="ExampleScreenshots/record_keeper_example_2.jpg" height="500"><img src="ExampleScreenshots/record_keeper_example_3.jpg" height="500">

**Table of Contents**
- [Introduction](#introduction)
- [Motivation](#motivation)
- [Technology Used](#technologyUsed)
- [Build Status](#buildStatus)
- [Features](#features)
- [Installation](#installation)
- [Execution](#execution)

## Introduction <a name="introduction"></a>
An Android app to log Running and Cycling times. 

## Motivation <a name="motivation"></a>
This is a personal learning project aimed to teach me the tools and technology needed to build a native Android application. As later I would like to deploy an Android application to the Google Play store.

## Technology Used <a name="technologyUsed"></a>
<table>
  <tbody>
    <tr>
      <td>Language</td>
      <td>Kotlin</td>
    </tr>
    <tr>
      <td>Frameworks</td>
      <td>Android Native Components</td>
      <td>Material Design</td>
    </tr>
  </tbody>
</table>

## Build Status <a name="buildStatus"></a>
Project is completed.

## Features <a name="features"></a>
- Bottom navigation bar
- Fragmented activity views of Running and Cycling records
- Scrollable list of records
- Editable records that are saved in the phone's memory

### Navigation bar

<img src="ExampleScreenshots/example-navigationBar.jpg" height="500">

* User can switch between activity views by selecting either one of the icons on the bottom navigation bar

### Featured window - Categories

<img src="ExampleScreenshots/example-featured-categories.jpg" height="500"><img src="ExampleScreenshots/example-fearured-categories2.jpg" height="400">

* User can see Landmarks grouped together by their category
* Landmarks are automatically grouped together depending on their underlying json data category field

### Featured window - Horizontal scrollable cards

<img src="ExampleScreenshots/example-featured-horizontalScroll-1.jpg" height="500"><img src="ExampleScreenshots/example-featured-horizontalScroll-2.jpg" height="500">

* User can scroll horizontally through each category to view the different landmarks
* User can also click on each image to take them to a detail view of each landmark

### List window - Favourite Filter

<img src="ExampleScreenshots/example-list-Favourites-1.jpg" height="500"><img src="ExampleScreenshots/example-list-Favourites-2.jpg" height="500">

* User can filter the list of landmarks by showing only their favourites by toggling the favourite button

### Detail window - Landmark information

<img src="ExampleScreenshots/example-detail-landmarkInformation.jpg" height="500">

* User can view detailed information about a particular landmark they selected in the featured or list activity window
* Information includes title, text location, geographical map, and description

### Detail window - favourite 

<img src="ExampleScreenshots/example-list-FavouriteIcon.jpg" height="500">

* User can toggle on/off if a landmark should be favourited or not

Detail window - Maps

<img src="ExampleScreenshots/example-detail-maps-1.jpg" height="500"><img src="ExampleScreenshots/example-detail-maps-2.jpg" height="500">

* User can interact with the map on the detail activity window to view the surrounding area

# Installation <a name="installation"></a>
* Ensure XCode is installed (only available on MacOS)

# Execution <a name="execution"></a>
* Open the Landmarks.xcodeproj file in XCode
* Once the project is open you can click the play button at the top of the IDE to run the iPhone simulator
