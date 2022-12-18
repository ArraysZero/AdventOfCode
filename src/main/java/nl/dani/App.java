package nl.dani;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import nl.dani.chllg1.Elf;
import nl.dani.chllg1.InputReader;
import nl.dani.chllg5.CrateStack;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		InputReader reader = new InputReader();

		// System.out.println(reader.readFile("input1.txt"));
		ArrayList<Elf> content = reader.readCalories("input1.txt");

		System.out.println("content is " + content.size() + " of elves\n");
		int Maxcal = 0;
		for (int i = 0; i < content.size(); i++) {
			// System.out.println(content.get(i).getAllCalories());
			if (content.get(i).getAllCalories() > Maxcal) {
				Maxcal = content.get(i).getAllCalories();
			}
		}

		System.out.println("day 1: challenge 1: " + Maxcal);

		int[] topThree = { 0, 0, 0 };

		for (int i = 0; i < content.size(); i++) {
			int smallest = 0;

			for (int n = 0; n < 3; n++) {
				if (topThree[smallest] > topThree[n]) {
					smallest = n;
				}
			}

			if (content.get(i).getAllCalories() > topThree[smallest]) {
				topThree[smallest] = content.get(i).getAllCalories();
			}
		}

		System.out.println("day 1: challenge 2: " + (topThree[0] + topThree[1] + topThree[2]));

		ArrayList<String> games = reader.readGames("input2.txt");
		HashMap<String, Integer> lookup = new HashMap();
		lookup.put("A X", 4);
		lookup.put("A Y", 8);
		lookup.put("A Z", 3);
		lookup.put("B X", 1);
		lookup.put("B Y", 5);
		lookup.put("B Z", 9);
		lookup.put("C X", 7);
		lookup.put("C Y", 2);
		lookup.put("C Z", 6);

		// System.out.println(games.size());
		int score = 0;
		for (int i = 0; i < games.size(); i++) {
			score += lookup.get(games.get(i));
		}

		System.out.println("day 2: challenge 1: " + score);

		HashMap<String, Integer> lookupd = new HashMap();
		lookupd.clear();
		lookupd.put("A X", 3);
		lookupd.put("A Y", 4);
		lookupd.put("A Z", 8);
		lookupd.put("B X", 1);
		lookupd.put("B Y", 5);
		lookupd.put("B Z", 9);
		lookupd.put("C X", 2);
		lookupd.put("C Y", 6);
		lookupd.put("C Z", 7);

		score = 0;
		for (int i = 0; i < games.size(); i++) {
			score += lookupd.get(games.get(i));
		}

		System.out.println("day 2: challenge 2: " + score);

		ArrayList<String> rucksacks = reader.readGames("input3.txt");

		// System.out.println(((int) 'z') - 96); //char - 96 l of -64 u
		int total = 0;
		for (int i = 0; i < rucksacks.size(); i++) {
			int length = rucksacks.get(i).length();
			char[] left = rucksacks.get(i).substring(0, length / 2).toCharArray();
			char[] right = rucksacks.get(i).substring(length / 2).toCharArray();

			Arrays.sort(left);
			Arrays.sort(right);

			boolean found = false;
			for (int n = 0; n < left.length; n++) {
				for (int t = 0; t < right.length; t++) {
					if (left[n] == right[t] && !found) {
						found = true;
						if (((int) left[n]) >= 97) {
							total += (int) left[n] - 96;
						} else {
							total += (int) left[n] - 38;
						}
						// break;
					}
				}
			}
		}

		System.out.println("day 3; challenge 1: " + total);

		total = 0;
		// boolean found = false;
		for (int i = 0; i < rucksacks.size(); i += 3) {
			boolean found = false;
			for (int n = 0; n < rucksacks.get(i).length(); n++) {
				for (int t = 0; t < rucksacks.get(i + 1).length(); t++) {
					for (int e = 0; e < rucksacks.get(i + 2).length(); e++) {
						if ((rucksacks.get(i).charAt(n) == rucksacks.get(i + 1).charAt(t))
								&& (rucksacks.get(i).charAt(n) == rucksacks.get(i + 2).charAt(e) && !found)) {
							found = true;
							if (((int) rucksacks.get(i).charAt(n)) >= 97) {
								total += (int) rucksacks.get(i).charAt(n) - 96;
							} else {
								total += (int) rucksacks.get(i).charAt(n) - 38;
							}
						}
					}
				}
			}
		}

		System.out.println("day3: challenge 2: " + total);

		ArrayList<String> ranges = reader.readGames("input4.txt");

		// System.out.println(ranges.size());
		int encapsulatingRanges = 0;
		int overlappingPairs = 0;
		for (int i = 0; i < ranges.size(); i++) {
			// System.out.println(ranges.get(i));
			String[] range = { ranges.get(i).substring(0, ranges.get(i).indexOf(',')),
					ranges.get(i).substring(ranges.get(i).indexOf(',') + 1) };
			int[] leftRange = { Integer.valueOf(range[0].substring(0, range[0].indexOf('-'))),
					Integer.valueOf(range[0].substring(range[0].indexOf('-') + 1)) };
			int[] rightRange = { Integer.valueOf(range[1].substring(0, range[1].indexOf('-'))),
					Integer.valueOf(range[1].substring(range[1].indexOf('-') + 1)) };

			// System.out.println(range[0] + " " + range[1]);
			if ((leftRange[0] <= rightRange[0] && leftRange[1] >= rightRange[1])
					|| (leftRange[0] >= rightRange[0] && leftRange[1] <= rightRange[1])) {
				// System.out.println(Integer.valueOf(range[0].substring(0,
				// range[0].indexOf('-'))));
				// System.out.println("encapsulates");
				encapsulatingRanges++;
			}

			if ((leftRange[0] <= rightRange[0] && leftRange[1] >= rightRange[0])
					|| (rightRange[0] <= leftRange[0] && rightRange[1] >= leftRange[0])) {
				overlappingPairs++;
			}

			// if (Integer.valueOf(range[0].))
		}

		System.out.println("day4: challenge 1: " + encapsulatingRanges);
		System.out.println("day4: challenge 2: " + overlappingPairs);

		// [C] [Q] [V]
		// [D] [D] [S] [M] [Z]
		// [G] [P] [W] [M] [C] [G]
		// [F] [Z] [C] [D] [P] [S] [W]
		// [P] [L] [C] [V] [W] [W] [H] [L]
		// [G] [B] [V] [R] [L] [N] [G] [P] [F]
		// [R] [T] [S] [S] [S] [T] [D] [L] [P]
		// [N] [J] [M] [L] [P] [C] [H] [Z] [R]
		// 1 2 3 4 5 6 7 8 9

		CrateStack crateStack = new CrateStack(9);
		CrateStack crateStackClone = new CrateStack(9);

		char[] crates = { 'N', 'R', 'G', 'P' };
		crateStack.addStack(0, crates);
		crateStackClone.addStack(0, crates);
		char[] crates1 = { 'J', 'T', 'B', 'L', 'F', 'G', 'D', 'C' };
		crateStack.addStack(1, crates1);
		crateStackClone.addStack(1, crates1);
		char[] crates2 = { 'M', 'S', 'V' };
		crateStack.addStack(2, crates2);
		crateStackClone.addStack(2, crates2);
		char[] crates3 = { 'L', 'S', 'R', 'C', 'Z', 'P' };
		crateStack.addStack(3, crates3);
		crateStackClone.addStack(3, crates3);
		char[] crates4 = { 'P', 'S', 'L', 'V', 'C', 'W', 'D', 'Q' };
		crateStack.addStack(4, crates4);
		crateStackClone.addStack(4, crates4);
		char[] crates5 = { 'C', 'T', 'N', 'W', 'D', 'M', 'S' };
		crateStack.addStack(5, crates5);
		crateStackClone.addStack(5, crates5);
		char[] crates6 = { 'H', 'D', 'G', 'W', 'P' };
		crateStack.addStack(6, crates6);
		crateStackClone.addStack(6, crates6);
		char[] crates7 = { 'Z', 'L', 'P', 'H', 'S', 'C', 'M', 'V' };
		crateStack.addStack(7, crates7);
		crateStackClone.addStack(7, crates7);
		char[] crates8 = { 'R', 'P', 'F', 'L', 'W', 'G', 'Z' };
		crateStack.addStack(8, crates8);
		crateStackClone.addStack(8, crates8);

		ArrayList<String> moves = reader.readGames("input5.txt");

		for (int i = 0; i < moves.size(); i++) {
			// System.out.println(moves.get(i));

			int currentIndex;
			int numMoves = Integer.valueOf(moves.get(i).substring(5, moves.get(i).indexOf('f') - 1));
			currentIndex = moves.get(i).indexOf('f') + 1;
			int start = Integer.valueOf(
					moves.get(i).substring(moves.get(i).indexOf(' ', currentIndex) + 1, moves.get(i).indexOf('t') - 1));
			currentIndex = moves.get(i).indexOf('t') + 1;
			int destination = Integer.valueOf(moves.get(i).substring(moves.get(i).indexOf(' ', currentIndex) + 1));

			// System.out.println(numMoves + " " + start + " " + destination);

			for (int n = 0; n < numMoves; n++) {
				crateStack.moveCrate(start - 1, destination - 1);
			}
			crateStackClone.moveCrates(start - 1, destination - 1, numMoves);

			// System.out.println(moves.get(i).indexOf('e'));
			// int moveN =
			// Integer.valueOf(moves.get(i).substring(moves.get(i).indexOf('e')))
		}

		System.out.println("day5: challenge 1: " + crateStack.getTopCrates());
		System.out.println("day5: challenge 2: " + crateStackClone.getTopCrates());

		String datastream = reader.readGames("input6.txt").get(0);
		// String pattern = "(?:([a-z])(?!.*\1)){4}";
		// Pattern pattern = Pattern.compile("(?:([a-z])(?!.*\1)){4}");

		boolean pkg = false;
		for (int i = 0; i < datastream.length(); i++) {
			// Matcher match = pattern.matcher(datastream.substring(i, i + 4));

			// if (match.find()){
			// System.out.println("day6: challenge 1: " + (i + 4));
			// i = datastream.length();
			// }

			String substr = datastream.substring(i, i + 4);
			int uniquechars = 0;
			for (int n = 3; n >= 0; n--) {
				if (substr.indexOf(substr.charAt(n)) == n) {
					uniquechars++;
				}
			}
			if (uniquechars == 4 && !pkg) {
				System.out.println("day6: challenge 1: " + (i + 4));
				// i = datastream.length() + 4;
				pkg = true;
			}

			String sbstr = datastream.substring(i, i + 14);
			uniquechars = 0;
			for (int n = 13; n >= 0; n--) {
				if (sbstr.indexOf(sbstr.charAt(n)) == n) {
					uniquechars++;
				}
			}
			if (uniquechars == 14) {
				System.out.println("day6: challenge 1: " + (i + 14));
				i = datastream.length() + 4;
			}
		}
		// System.out.println(datastream);`

		ArrayList<String> terminal = reader.readGames("input7.txt");

		// EFSNode root = new EFSNode();

		ArrayList<String> scope = new ArrayList();
		scope.add("/");
		Map<String, Integer> folderSize = new HashMap<>();
		folderSize.put("/", 0);

		// folderSize.put("kut", 20);
		// System.out.println(folderSize);
		for (int i = 1; i < terminal.size(); i++) {
			// System.out.println(terminal.get(i));

			if (terminal.get(i).startsWith("$")) {
				if (terminal.get(i).startsWith("$ cd")) {
					if (terminal.get(i).substring(5).equals("..")) {
						scope.remove(scope.size() - 1);
					} else {
						// String name = "";
						scope.add(scope.get(scope.size() - 1) + terminal.get(i).substring(5) + "/");
						String folder = scope.get(scope.size() - 1);
						// System.out.println(folder);
						folderSize.put(folder, 0);
						// System.out.println(folderSize);
					}
				}
			} else {
				if (!terminal.get(i).startsWith("dir")) {
					// System.out.println(folderSize);
					for (int n = 0; n < scope.size(); n++) {
						folderSize.replace(scope.get(n), folderSize.get(scope.get(n))
								+ Integer.valueOf(terminal.get(i).substring(0, terminal.get(i).indexOf(" "))));
					}
				}
			}

		}

		int totalSize = 0;
		int deletedDit = 700000000;
		int spaceNeeeded = 30000000 - (70000000 - folderSize.get("/"));

		for (Integer size : folderSize.values()) {
			// System.out.println(folderSize);
			if (size < 100000) {
				totalSize += size;
			}

			if (size < deletedDit && size >= spaceNeeeded) {
				deletedDit = size;
			}
		}

		// System.out.println(folderSize.get("/") + " " + deletedDit);

		System.out.println("day7: challenge 1: " + totalSize);
		System.out.println("day7: challenge 2: " + deletedDit);

		ArrayList<String> rows = reader.readGames("input8.txt");

		int[][] treeGrid = new int[rows.size()][rows.get(0).length()];
		int columns = rows.get(0).length();
		int row = rows.size();
		// System.out.println(row);

		for (int i = 0; i < row; i++) {
			for (int n = 0; n < columns; n++) {
				treeGrid[i][n] = Integer.valueOf(rows.get(i).substring(n, n + 1));
				// System.out.print(treeGrid[i][n] + " ");
			}
		}

		int visibleTrees = 0;
		int scenicScore = 0;
		for (int i = 0; i < row; i++) {
			// System.out.println(" ");
			for (int n = 0; n < columns; n++) {
				// boolean visible = false;
				boolean ttl = false;
				boolean ttr = false;
				boolean ttu = false;
				boolean ttb = false;
				int distanceL = 0;
				int distanceR = 0;
				int distanceU = 0;
				int distanceB = 0;

				// System.out.print(treeGrid[i][n] + " -> ");
				for (int t = i - 1; t >= 0; t--) {
					// System.out.print(treeGrid[t][n] + " | ");
					if (treeGrid[i][n] > treeGrid[t][n]) {
						distanceU++;
					} else {
						// System.out.println(n +" "+ i + " " + treeGrid[i][n] + " " + treeGrid[t][n] +
						// " left");
						t = 0;
						distanceU++;
					}
				}
				// System.out.print("distance = " + distanceU);

				for (int t = i + 1; t < row; t++) {
					// System.out.print(treeGrid[t][n] + " | ");
					if (treeGrid[i][n] > treeGrid[t][n]) {
						distanceB++;
					} else {
						t = row;
						distanceB++;
					}
				}
				// System.out.print("distance = " + distanceB + "\n");

				for (int t = n - 1; t >= 0; t--) {
					// System.out.print(treeGrid[i][n] + " | ");
					if (treeGrid[i][n] > treeGrid[i][t]) {
						distanceL++;
					} else {
						t = 0;
						distanceL++;
					}
				}
				// System.out.print("distance = " + distanceL + "\n");

				for (int t = n + 1; t < columns; t++) {
					// System.out.print(treeGrid[i][n] + " | ");
					if (treeGrid[i][n] > treeGrid[i][t]) {
						distanceR++;
					} else {
						t = columns;
						distanceR++;
					}
				}
				// System.out.print("distance = " + distanceR + "\n");

				// System.out.println(treeGrid[i][n] + " -> " + (distanceU + " " + distanceB + "
				// " + distanceL + " " + distanceR) + " | " + (distanceU * distanceB * distanceL
				// * distanceR));
				if ((distanceU * distanceB * distanceL * distanceR) > scenicScore) {
					// System.out.println(scenicScore);
					scenicScore = (distanceU * distanceB * distanceL * distanceR);
				}

				for (int t = 0; t < row; t++) {
					// System.out.print(t);

					if (treeGrid[i][n] <= treeGrid[t][n]) {
						// System.out.print(t + " = " + treeGrid[i][n] + " " + treeGrid[t][n] + " | ");
						if (t < i) {
							ttu = true;
						} else if (t > i) {
							ttb = true;
						}
					}
				}

				// System.out.println(" ");

				for (int t = 0; t < columns; t++) {
					if (treeGrid[i][n] <= treeGrid[i][t]) {
						// System.out.print(t + " = " + treeGrid[i][n] + " " + treeGrid[t][n] + " | ");
						if (t < n) {
							ttl = true;
						} else if (t > n) {
							ttr = true;
							// System.out.print(treeGrid[i][n] + " " + i + " " + n + " " + t + " rechts |
							// ");
						}
					}
				}

				if (!ttu || !ttb || !ttl || !ttr) {
					visibleTrees++;
					// System.out.print(treeGrid[i][n] + " " + i + " " + n);
				} else if (ttr) {
					// System.out.print(treeGrid[i][n] + " " + i + " " + n);
				}
			}
		}

		// System.out.println(visibleTrees);

		// visibleTrees += (row + columns) + 1;

		System.out.println("day8: challenge 1: " + visibleTrees);
		System.out.println("day8: challenge 2: " + scenicScore);

		ArrayList<String> ropeMoves = reader.readGames("input9.txt");
		int[][] knots = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 },
				{ 0, 0 } };

		ArrayList<String> pos2 = new ArrayList<>();
		pos2.add("0 0");
		ArrayList<String> pos10 = new ArrayList<>();
		pos10.add("0 0");

		for (int i = 0; i < ropeMoves.size(); i++) {
			// System.out.println(ropeMoves.get(i));

			String direction = ropeMoves.get(i).substring(0, 2);
			int steps = Integer.valueOf(ropeMoves.get(i).substring(2));
			// System.out.println(direction + "| " + steps);

			for (int n = 0; n < steps; n++) {
				switch (direction) {
					case "R ":
						knots[0][0]++;
						// System.out.println("R");
						break;
					case "L ":
						knots[0][0]--;
						// System.out.println("L");
						break;
					case "U ":
						knots[0][1]++;
						// System.out.println("U");
						break;
					case "D ":
						knots[0][1]--;
						// System.out.println("D");
						break;
					default:
						break;
				}

				for (int j = 1; j < knots.length; j++) {
					// System.out.println("controle " + n + " | " + j);
					if (knots[j - 1][0] - knots[j][0] == 2 && knots[j - 1][1] - knots[j][1] == 2) {
						knots[j][0] = knots[j - 1][0] - 1;
						knots[j][1] = knots[j - 1][1] - 1;
					} else if (knots[j - 1][0] - knots[j][0] == 2 && knots[j - 1][1] - knots[j][1] == -2) {
						knots[j][0] = knots[j - 1][0] - 1;
						knots[j][1] = knots[j - 1][1] + 1;
					} else if (knots[j - 1][0] - knots[j][0] == -2 && knots[j - 1][1] - knots[j][1] == 2) {
						knots[j][0] = knots[j - 1][0] + 1;
						knots[j][1] = knots[j - 1][1] - 1;
					} else if (knots[j - 1][0] - knots[j][0] == -2 && knots[j - 1][1] - knots[j][1] == -2) {
						knots[j][0] = knots[j - 1][0] + 1;
						knots[j][1] = knots[j - 1][1] + 1;
					} else if (knots[j - 1][0] - knots[j][0] == 2) {
						// System.out.println("beweging naar rechts " + j);
						knots[j][0] = knots[j - 1][0] - 1;
						knots[j][1] = knots[j - 1][1];
					} else if (knots[j][0] - knots[j - 1][0] == 2) {
						knots[j][0] = knots[j - 1][0] + 1;
						knots[j][1] = knots[j - 1][1];
					} else if (knots[j - 1][1] - knots[j][1] == 2) {
						knots[j][0] = knots[j - 1][0];
						knots[j][1] = knots[j - 1][1] - 1;
					} else if (knots[j][1] - knots[j - 1][1] == 2) {
						knots[j][0] = knots[j - 1][0];
						knots[j][1] = knots[j - 1][1] + 1;
					}
				}

				String pos = knots[1][0] + " " + knots[1][1];
				boolean newPos = false;
				for (int j = 0; j < pos2.size(); j++) {
					if (pos2.get(j).equals(pos)) {
						newPos = true;
					}
				}
				if (!newPos) {
					// System.out.println("niuewe pos");
					pos2.add(pos);
				}

				pos = knots[9][0] + " " + knots[9][1];
				newPos = false;
				for (int j = 0; j < pos10.size(); j++) {
					if (pos10.get(j).equals(pos)) {
						newPos = true;
					}
				}
				if (!newPos) {
					// System.out.println(pos);
					pos10.add(pos);
				}

				for (int index = 0; index < knots.length; index++) {
					// System.out.print(" (" + knots[index][0] + " | " + knots[index][1] + ") ");
				}
				// System.out.println("");
			}
		}

		System.out.println("day9: challenge 1: " + pos2.size());
		System.out.println("day9: challenge 2: " + pos10.size());
		// // System.out.println(ropeMoves.size());
		// int headXP = 0;
		// int headYP = 0;
		// int tailXP = 0;
		// int tailYP = 0;

		// ArrayList<String> TailPos = new ArrayList();

		// for (int i = 0; i < ropeMoves.size(); i++) {
		// // System.out.println(" (" + headXP + ", " + headYP + ") -> (" + tailXP + ",
		// " +
		// // tailYP + ")");

		// // System.out.print("\n" + ropeMoves.get(i));
		// String direction = ropeMoves.get(i).substring(0, ropeMoves.get(i).indexOf("
		// "));
		// int times =
		// Integer.valueOf(ropeMoves.get(i).substring(ropeMoves.get(i).indexOf(" ") +
		// 1));
		// // System.out.print(direction + "|" + times);

		// for (int t = 0; t < times; t++) {
		// System.out.println(" (" + headXP + ", " + headYP + ") -> (" + tailXP + ", " +
		// tailYP + ")");
		// // System.out.println(t);

		// switch (direction) {
		// case "R":
		// headXP++;
		// break;
		// case "L":
		// headXP--;
		// break;
		// case "U":
		// headYP++;
		// break;
		// case "D":
		// headYP--;
		// break;
		// default:
		// break;
		// }

		// if (((headXP - tailXP) > 1 || (headXP - tailXP) < -1)
		// || ((headYP - tailYP) < -1 || (headYP - tailYP) > 1)) {
		// // tailXP += (headXP - tailXP) / 2;
		// // }
		// // if ((headYP - tailYP) > 1 || (headYP - tailYP) < 1) {
		// // tailYP += (headYP - tailYP) / 2;
		// switch (direction) {
		// case "R":
		// // System.out.println("tail moves right" + (tailXP - headXP));
		// tailXP = headXP - 1;
		// tailYP = headYP;
		// break;
		// case "L":
		// tailXP = headXP + 1;
		// tailYP = headYP;
		// break;
		// case "U":
		// tailXP = headXP;
		// tailYP = headYP - 1;
		// break;
		// case "D":
		// tailXP = headXP;
		// tailYP = headYP + 1;
		// break;
		// default:
		// break;
		// }
		// }

		// String currentTailPos = tailXP + " " + tailYP;
		// boolean newPos = true;
		// for (int n = 0; n < TailPos.size(); n++) {
		// if (TailPos.get(n).equals(currentTailPos)) {
		// newPos = false;
		// n = TailPos.size() + 1; // end the loop
		// }
		// }

		// // System.out.println(currentTailPos);
		// if (newPos) {
		// TailPos.add(currentTailPos);
		// }
		// // System.out.println(direction + " (" + headXP + ", " + headYP + ") -> " +
		// // currentTailPos + "\n");
		// }
		// }

		// System.out.println(ropeMoves.size() + " " + TailPos.size());
		// for (int i = 0; i < TailPos.size(); i++) {
		// // System.out.println(TailPos.get(i));
		// }
	}
}