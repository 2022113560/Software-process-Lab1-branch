package P2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import P1.graph.ConcreteVerticesGraph;

public class FriendshipGraph {
	private final ConcreteVerticesGraph<Person> people;

	/**
	 * @return ConcreteVerticesGraph
	 */
	public ConcreteVerticesGraph<Person> getPeople() {
		return people;
	}

	public FriendshipGraph() {
		people = new ConcreteVerticesGraph<>();
	}

	/**
	 * Add vertexes to graph or we can say add person into social network.
	 * @param newPerson
	 */
	public void addVertex(Person newPerson) {
		people.add(newPerson);
	}

	/**
	 * Add edges to graph or we can say add interaction into social network.
	 * @param pa
	 * @param pb
	 */
	public void addEdge(Person pa, Person pb) {
		people.set(pa, pb, 1);
	}

	/**
	 * @param Person1
	 * @param Person2
	 * @return the distance between the two people.
	 */
	public int getDistance(Person Person1, Person Person2) {
		if (Person1 == Person2)
			return 0;
		Queue<Person> queue = new LinkedList<>();
		Map<Person, Integer> distantMap = new HashMap<>();
		queue.offer(Person1);
		distantMap.put(Person1, 0);
		while (!queue.isEmpty()) {
			Person topPerson = queue.poll();
			int nowDis = distantMap.get(topPerson);
			Set<Person> friendList = people.targets(topPerson).keySet();
			for (Person ps : friendList)
				if (!distantMap.containsKey(ps)) {
					distantMap.put(ps, nowDis + 1);
					queue.offer(ps);
					if (ps == Person2) {
						return distantMap.get(Person2);
					}
				}
		}
		return -1;
	}

//	public static void main(String args[]) {
//		FriendshipGraph graph = new FriendshipGraph();
//		Person rachel = new Person("Rachel");
//		Person ross = new Person("ross");
//		Person ben = new Person("Ben");
//		Person kramer = new Person("Kramer");
//		graph.addVertex(rachel);
//		graph.addVertex(ross);
//		graph.addVertex(ben);
//		graph.addVertex(kramer);
//		graph.addEdge(rachel, ross);
//		graph.addEdge(ross, rachel);
//		graph.addEdge(ross, ben);
//		graph.addEdge(ben, ross);
//		System.out.println(graph.getDistance(rachel, ross));
//		System.out.println(graph.getDistance(rachel, ben));
//		System.out.println(graph.getDistance(rachel, rachel));
//		System.out.println(graph.getDistance(rachel, kramer));
//	}
}
