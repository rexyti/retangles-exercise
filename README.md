# Rectangles

## Problem Description:

An algorithms that analyze rectangles and features that exist among rectangles. The implementation required to cover the following: 
1. **Intersection**: You must be able to determine whether two rectangles have one or more intersecting lines and produce a result identifying the points of interception .  
2. **Containment**: You must be able to determine whether a rectangle is wholly contained within another rectangle. 
3. **Adjacency**: Implement the ability to detect whether two rectangles are adjacent. Adjacency is defined as the sharing of at least one side. Side sharing may be proper, sub-line or partial. A sub-line share is a share where one side of rectangle A is a line that exists as a set of points wholly contained on some other side of rectangle B, where partial is one where some line segment on a side of rectangle A exists as a set of points on some side of Rectangle B. 

## Solution
An algorithm is generated to solve the exercise.

**Entities:**
Three basic entities are created: *point*, *line* and *rectangle*.

*The rectangle* class has methods to identify whether a point is inside, on the edge, or one of its vertices.

**Use cases:**
5 use cases are created:

 - Evaluate partial adjacency
 - Evaluate proper adjacency
 - Evaluate sub-line adjacency
 - Evaluate Contain
 - Evaluate intersection

**Services**
They create a service that evaluates all use cases and forms a readable response

**interface**
A rest interface is created for the use of the app

## How to use
run the spring boot application and use the following example curl:

    curl --location 'http://localhost:8080/figures/rectangles/evaluate' \
    --header 'Content-Type: application/json' \
    --data  '{
	    "rectangle_a" : {
		    "main_vertex" : {
			    "x" : 1,
			    "y" : 1
		    },
		    "height" : 5,
		    "weight" : 9
	    },
	    "rectangle_b" : {
		    "main_vertex" : {
			    "x" : 2,
			    "y" : 1
		    },
		    "height" : 1,
		    "weight" : 1
		   }
    }'

## Test cases
**inside**

<img width="250" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/f2ade9e1-ce04-4e59-adb0-103485246467">

-----------------------------------


**insideV1**

<img width="228" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/3d48c945-555a-4c4b-b4f5-2f2842d705a7">

-----------------------------------


**insideV2**

<img width="228" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/68ed42e7-9ff9-4cf5-a336-eaf7ab84aba2">

-----------------------------------


**insideV3**

<img width="228" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/ad87398b-7202-475f-b9d0-720d328706b6">

-----------------------------------


**insideV4**

<img width="228" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/bbe38b03-571e-4689-9bb8-8e4532e4fb5f">

-----------------------------------


**insideHorizontalEdge**

<img width="228" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/88063372-ac15-439c-8c67-927a8e0f24a5">

-----------------------------------


**insideVerticalEdge**

<img width="228" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/00ebb089-8503-4f33-9571-3a8b1441e890">

-----------------------------------

**properVerticalAdjacent**

<img width="310" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/f9cac685-df72-4d4c-81b5-f8afc2b43676">


-----------------------------------

**properHorizontalAdjacent**

<img width="310" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/3fe02967-47c2-42ca-a892-955635d305aa">


-----------------------------------

**subLineHorizontalAdjacent**

<img width="222" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/57c63d9e-48c9-48c4-835a-5a03aba9b797">


-----------------------------------

**subLineVerticalAdjacent**

<img width="343" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/d50610fa-145d-44be-8aca-16ad4aa8b2d7">


-----------------------------------

**partialHorizontalAdjacent**

<img width="315" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/c2beb220-bbe5-4df5-9622-baf285af7db6">


-----------------------------------

**partialVerticalAdjacent**

<img width="334" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/9f11c1b2-111d-4553-9a00-2dc42540c376">


-----------------------------------

**partialOneCommonVertexAdjacent**

<img width="361" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/0a1a8124-cc4c-450c-9bdd-0993f14af8af">


-----------------------------------

**oneVertexInsideIntersection**

<img width="312" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/9686e504-edbf-475f-8772-d3d0b5b9ac65">


-----------------------------------

**twoVertexInsideIntersection**

<img width="309" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/98cd9294-8f39-43c8-a07d-154930879715">

-----------------------------------


**twoVertexOnEdgeIntersection**

<img width="348" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/ddf4107d-f02b-46de-903a-d11d967f4acb">

-----------------------------------


**oneVertexOnEdgeIntersection**

<img width="309" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/c439811b-c385-4f14-a2fe-7212e8d71553">

-----------------------------------


**outsideRectangle**

<img width="348" alt="image" src="https://github.com/rexyti/retangles-exercise/assets/6185143/5da5d196-1031-47b2-85cc-fcaea601d481">


## Next steps
It is necessary to create the test for the service and the rest interface

