package P2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class FriendshipGraphTest {
	// Testing strategy
	// Partition for friendship graph
	//     empty graph, same Person, only one Person,
	//     graph with no addEdge, graph with no distance


	@Test(expected = AssertionError.class)
	public void testAssertionsEnabled() {
		assert false;
	}

	// covers empty graph
	@Test
	public void testEmptyGraph(){
		FriendshipGraph graph = new FriendshipGraph();
		Person person1 = new Person("Person1");
		Person person2 = new Person("Person2");
		assertEquals(-1, graph.getDistance(person1, person2));
	}

	//cover same Person
	public void testsamePerson() {
		FriendshipGraph graph = new FriendshipGraph();
		Person a = new Person("a");
		graph.addVertex(a);
		Person f = new Person("a");
		assertFalse(graph.getPeople().vertices().contains(f));
	}

	//cover addEdge
	@Test
	public void testsaddEdge() {
		FriendshipGraph graph = new FriendshipGraph();
		Person a = new Person("a");
		Person b = new Person("b");
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addEdge(a, b);
		assertEquals("expected distance", 1, graph.getDistance(a, b));
	}

	//cover no addEdge
	@Test
	public void testsaddEdgenotexist() {
		FriendshipGraph graph = new FriendshipGraph();
		Person a = new Person("a");
		Person b = new Person("b");
		graph.addEdge(a, b);
		assertEquals("expected distance", 1, graph.getDistance(a, b));
	}

	//cover FriendshipGraph
	@Test
	public void testFriendshipGraph() {
		FriendshipGraph graph = new FriendshipGraph();
		Person a = new Person("a");
		Person b = new Person("b");
		Person c = new Person("c");
		Person d = new Person("d");
		graph.addEdge(a, b);
		graph.addEdge(b, c);
		graph.addEdge(c, d);
		assertEquals("expected distance", 1, graph.getDistance(a, b));
		assertEquals("expected distance", 1, graph.getDistance(b, c));
		assertEquals("expected distance", 1, graph.getDistance(c, d));
		assertEquals("expected distance", 2, graph.getDistance(a, c));
		assertEquals("expected distance", 2, graph.getDistance(b, d));
		assertEquals("expected distance", 3, graph.getDistance(a, d));
		assertEquals("expected distance", -1, graph.getDistance(b, a));
	}

}
