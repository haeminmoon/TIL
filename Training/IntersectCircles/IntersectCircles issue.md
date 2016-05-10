# IntersectCircles

**여러개의 원들이 서로 겹치는지 검사하는 문제**

	(id, centerX, centerY, radius)
	input : 5
			7 -10.00 20.00 15.00
			5 30.10 10.00 10.00
			3 20.10 10.00 10.00
			8 0.00 20.00 5.00
			1 10.00 20.00 10.00

	ouput : 1 3 
			1 7
			1 8
			3 5
			7 8

Issue : center의 좌표를 이용하여, 두 원의 중심 점과 점사이의 거리를 구한다. 
		그 후 (Distance < Radius) 조건이 성립하면 겹치는 원이다.

		**twoDistance = (float) Math.sqrt(xdiff * xdiff + ydiff * ydiff);**
		**twoRadius = c1.radius + c2.radius;**
		
		**if(twoDistance < twoRadius)**
			**return true;**
		**else**
			**return false;**