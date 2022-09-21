// +На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
// - команда 1 (к1): увеличить в с раза, а умножается на c
// - команда 2 (к2): увеличить на d, к a прибавляется d
// написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b
// или сообщить, что это невозможно
// Пример 1: а = 1, b = 7, c = 2, d = 1
// Показать набор команд для превращения числа а в число b
// Показать хотя бы один набор

public class HomeWork1 {
    static int solve(int[] ways, int start, int end, int add, int mult) {
      ways[start] = 1;
      for (int index = start + add; index <= end; index++) {
        if (index % mult == 0) {
          ways[index] = ways[index - add] + ways[index / mult];
        } else {
          ways[index] = ways[index - add];
        }
      }
      System.out.println(print(ways));
      return ways[end];
    }
  
    static void print_instruction_set(StringBuffer instr_set) {
      System.out.println("Набор одного из вариантов команд:");
      System.out.println(instr_set);
    }
  
    static StringBuffer instruction_set(StringBuffer instr_set, int[] ways, int start, int end, int add, int mult) {
      while (end >= start) {
        if (end == start) {
          instr_set = instr_set.replace(instr_set.length() - 2, instr_set.length(), ".");
          break;
        } else {
          if (end % mult == 0 && ways[end / 2] != 0 && end / mult >= start) {
            instr_set.insert(0, String.format("*%d, ", mult));
            end = end / mult;
          } else {
            if (ways[end - add] != 0 && end - add >= start) {
              instr_set.insert(0, String.format("+%d, ", add));
              end = end - add;
            }
          }
        }
      }
      return instr_set;
    }
  
    static String print(int[] items) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < items.length; i++) {
        sb.append(String.format("(%d)%d ", i, items[i]));
      }
      return sb.toString();
    }
  
    public static void main(String[] args) {
      int start = 3;
      int end = 10;
      int add = 1;
      int mult = 2;
      int[] ways = new int[end + 1];
      StringBuffer instr_set = new StringBuffer();
      System.out.println(String.format("Количество вариантов превращения числа %d в число %d = %d ", start, end,
          solve(ways, start, end, add, mult)));
      instr_set = instruction_set(instr_set, ways, start, end, add, mult);
      if (ways[end] != 0) {
        print_instruction_set(instr_set);
      }
    }
  }  

