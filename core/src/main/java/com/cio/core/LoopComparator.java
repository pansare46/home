package com.cio.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 * 
 * @author : cogman https://gist.github.com/cogman/f892498a66557285502f
 *
 */
public class LoopComparator {

	private static volatile Integer val;

	private static List<Integer> stuff = new ArrayList<>(1000);
	private static Integer[] array;

	static {
		for (int i = 0; i < 1000; ++i)
			stuff.add(i);
		array = stuff.toArray(new Integer[stuff.size()]);
	}

	public static void main(String[] args) {
		while (true) {
			benchmark(LoopComparator::array, "Array: ");
			benchmark(LoopComparator::arrayIndex, "Array Index: ");
			benchmark(LoopComparator::iterators, "Iterators: ");
			benchmark(LoopComparator::index, "Index: ");
			benchmark(LoopComparator::stream, "Stream: ");
			benchmark(LoopComparator::parallelStream, "Parallel Stream: ");
			System.out.println("");
		}
	}

	private static void array() {
		for (Integer item : array) {
			val = item;
		}
	}

	private static void arrayIndex() {
		int size = array.length;
		for (int i = 0; i < size; i++) {
			val = array[i];
		}
	}

	private static void iterators() {
		for (Integer thing : stuff) {
			val = thing;
		}
	}

	private static void index() {
		int size = stuff.size();
		for (int i = 0; i < size; i++) {
			val = stuff.get(i);
		}
	}

	private static void stream() {
		stuff.stream().forEach((thing) -> {
			val = thing;
		});
	}

	private static void parallelStream() {
		stuff.parallelStream().forEach((thing) -> {
			val = thing;
		});
	}

	private static void benchmark(Runnable r, String name) {
		long loops = 0;
		Stopwatch watch = Stopwatch.createStarted();
		while (watch.elapsed(TimeUnit.MILLISECONDS) < 1000) {
			r.run();
			++loops;
		}
		System.out.println(name + loops);
	}
}
