package br.com.alldirect.teste;

import java.lang.reflect.Array;

class Metodo<T> {
	public T[] queue;
	public int front;
	public int rear;
	public int size;

	public Metodo(Class<T> clazz, int size) {
		queue = (T[]) Array.newInstance(clazz, size);
		this.front = 0;
		this.rear = 0;
		this.size = 0;
	}

	public void enqueue(T value) {
		if (size < queue.length) {
			queue[rear] = value;
			rear++;
			size++;
		} else {
			System.out
					.println("A quantidade de elementos que deseja inserir é maior que o tamanho permitido pela fila");
		}

	}

	public boolean filaVazia() {
		if (front == rear) {
			return true;
		}
		return false;

	}

	public T dequeue() {
		if (filaVazia()) {
			System.out.println("a fila está vazia, não há como remover");
		}
		T elementoRemovido = queue[front];
		front++;
		return elementoRemovido;
	}

	public void show() {
		if (filaVazia()) {
			System.out.println("a fila está vazia, não o que mostrar");
		}
		for (int i = front; i < rear; i++) {
			System.out.println(i + ": Position, person: " + queue[i]);
		}
	}

	public void peek() {
		System.out.println("o primeiro da fila é: " + queue[front]);
	}

}

public class Principal {

	public static void main(String[] args) {
		Metodo<String> metodoFila = new Metodo<String>(String.class, 10);
	
		metodoFila.enqueue("luan");
		metodoFila.enqueue("carol");
		metodoFila.enqueue("marcos");
		metodoFila.enqueue("joao");
		
		metodoFila.show();
		System.out.println();
		metodoFila.peek();
		
		System.out.println();
		
		System.out.println("removido: "+metodoFila.dequeue());
		System.out.println();
		metodoFila.show();
		metodoFila.peek();

		
		
	}

}
