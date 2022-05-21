import java.util.Arrays;

public class HashTable<T, R> {
    private Node[] arr = new Node[16];

    public void put(T key, R value) {
        resize();
        int index = Math.abs(key.hashCode()) % arr.length;
        if (arr[index] == null) {
            arr[index] = new Node<>(key, value);
        } else {
            var currentNode = arr[index];
            while (currentNode.getNext() != null) {
                if (currentNode.getKey().equals(key)) {
                    return;
                }
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node<>(key, value));
        }
    }

    public void print() {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < arr.length; index++) {
            result
                .append(index)
                .append(": ");
            if (arr[index] != null) {
                var currentNode = arr[index];
                while (currentNode.getNext() != null) {
                    result
                        .append(currentNode.getKey().toString())
                        .append(":")
                        .append(currentNode.getValue().toString());
                    if (currentNode.getNext() != null) {
                        result.append(" -> ");
                    } else break;
                    currentNode = currentNode.getNext();
                }
                result
                    .append(currentNode.getKey().toString())
                    .append(":")
                    .append(currentNode.getValue().toString());
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    private void resize() {
        for (var e: arr) {
            if (e == null) {
                return;
            }
        }
       arr = Arrays.copyOf(arr, arr.length + 16);
    }
}
