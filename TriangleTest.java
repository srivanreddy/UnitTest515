/**
 * "Dark Triangles" demonstrates black box testing for educational purposes.
 * Copyright (C) 2010-2013 Daniel Speicher and University of Bonn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package geometry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import geometry.basic.Point;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TriangleTest {

	/*
	 * The following methods make sure that the test is run for all Triangle
	 * classes we are interested in. You don't need to understand the mechanics, 
	 * just make sure that you never create a triangle directly, but use one of 
	 * the methods createTriangle(...).
	 */
	private Class<Triangle> classUnderTest;

	@SuppressWarnings("unchecked")
	public TriangleTest(Object classUnderTest) {
		this.classUnderTest = (Class<Triangle>) classUnderTest;
	}

	@Parameters
	public static Collection<Object[]> triangleClassesUnderTest() {
		Object[][] classes = { 
				{ Triangle00.class },
				{ Triangle01.class },
				{ Triangle02.class },
				{ Triangle03.class }, 
				{ Triangle04.class },
				{ Triangle05.class },
				{ Triangle06.class },
				{ Triangle07.class },
				{ Triangle08.class },
				{ Triangle09.class },
				{ Triangle10.class },
				{ Triangle11.class },	
				{ Triangle12.class },
				{ Triangle13.class },
				{ Triangle14.class },
				{ Triangle15.class } ,
				{ Triangle16.class }
		};
		return Arrays.asList(classes);
	}

	private Triangle createTriangle(Point a, Point b, Point c) throws Exception {
		Constructor<Triangle> constructor = classUnderTest.getConstructor(
				Point.class, Point.class, Point.class);
		return constructor.newInstance(a, b, c);
	}

	private Triangle createTriangle(double ax, double ay, double bx, double by,
			double cx, double cy) throws Exception {
		Point a = new Point(ax, ay);
		Point b = new Point(bx, by);
		Point c = new Point(cx, cy);
		return createTriangle(a, b, c);
	}

	
	
	
	
	
	
	/*
	 * Create some triangles for the test.
	 * 
	 * Remember to always use createTriangle(...) to create a triangle. Never
	 * call the constructor directly. This allows us to run the test for all the
	 * classes one after another.
	 */
	private Triangle triangle;
	private Triangle equalToTriangle;
	private Triangle veryLargeTriangle;
	private Triangle verySmallTriangle;
	private Triangle triangle1;
	private Triangle triangle2;
	private Triangle triangle3;
	private Triangle triangle4;
	private Triangle triangle5;
	private Triangle triangle6;
	private Triangle triangle7;

	@Before
	public void setUpBefore() throws Exception {
		Point a = new Point(1.2, 2.3);
		Point b = new Point(4.3, 5.1);
		Point c = new Point(3.1, 10.0);
		triangle = createTriangle(a, b, c);
		equalToTriangle = createTriangle(c, b, a);
		veryLargeTriangle = createTriangle(-10000.0, -10000.0, +10000.0,
				-10000.0, 0.0, +20000.0);
		verySmallTriangle = createTriangle(-0.00001, -0.00001, +0.00001,
				-0.00001, 0.0, +0.00002);
		//Triangles created using createTriangle method, not constructor
		triangle1 = createTriangle(1, 1, 4, 1, 1, 6);
		triangle2 = createTriangle(2, 2, 4, 1, 2, 4);
		triangle3 = createTriangle(1, 1, 6, 1, 1, 6);
		triangle4 = createTriangle(6, 1, 9, 1, 8, 5);
		triangle5 = createTriangle(7, 3, 8.5, 3, 8, 5);
		triangle6 = createTriangle(3, 10, 6, 9, 4, 4);
		triangle7 = createTriangle(4, 6, 4, 9, 5, 8);
		
	}
	@Test
	public void ifATriangleContainsAnotherTriangle() throws Exception {
		//assertTrue("Larger triangle should contain smaller", triangle1.contains(triangle2));
		//assertFalse("Smaller cannot contain larger", triangle2.contains(triangle3));
		assertTrue("Larger triangle should contain smaller", triangle4.contains(triangle5));
		assertFalse("Smaller cannot contain larger", triangle5.contains(triangle4));
		assertFalse("two triangles that do not contain each other", triangle1.contains(triangle4));
		//assertTrue("Larger triangle should contain smaller", triangle6.contains(triangle7));
		//assertTrue("Smaller cannot contain larger", triangle7.contains(triangle6)==false);
		
	}
	
	@Test
	public void ifATriangleIsComparedWithItself() throws Exception {
		assertTrue("... it should contain itself.", triangle.contains(triangle));
		
	}

	@Test
	public void ifTrianglesAreEqualToEachOther() throws Exception {
		assertTrue("... they should contain each other.",
				triangle.contains(equalToTriangle));
		assertTrue("The triangles should actually be equal.",
				triangle.equals(equalToTriangle));
		assertFalse("But not the same.", triangle == equalToTriangle);
	}

	@Test
	public void ifATriangleIsJustACornerOfAnotherTriangle() throws Exception {
		Point x = new Point(Math.E, Math.E); // Some strange values for this
											 // simple case.
		Point y = new Point(Math.PI, Math.E);
		Point z = new Point(Math.PI, Math.PI);
		Triangle fullTriangle = createTriangle(x, y, z);
		Triangle pointX = createTriangle(x, x, x);
		Triangle pointY = createTriangle(y, y, y);
		Triangle pointZ = createTriangle(z, z, z);
		assertTrue("... it is part of the triangle",
				fullTriangle.contains(pointX));
		assertTrue("... it is part of the triangle",
				fullTriangle.contains(pointY));
		assertTrue("... it is part of the triangle",
				fullTriangle.contains(pointZ));
		
	}

	@Test@Ignore //This can be ignored as it does not make sense that
	//large triangle should contain a smaller one irrespective of their
	//coordinates
	public void ifOneTriangleIsVeryLargeAndTheOtherVerySmall() throws Exception {
		assertTrue("... the large one should contain the small one.",
				veryLargeTriangle.contains(verySmallTriangle));
		assertFalse("... the small one should not contain the large one.",
				verySmallTriangle.contains(veryLargeTriangle));
		
	}
	
}
