package com.javatraining.designpattern.memento;

import java.util.ArrayList;

//Originator
public class Cart {
	ArrayList<Item> items = new ArrayList<Item>();

	public void addItem(Item item) {
		items.add(item);
	}

	public ArrayList<Item> getItems() {

		return (ArrayList<Item>) items.clone();

	}

	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}

	public CartMemento save() {
		return new CartMemento(getItems());

	}
	public void revert(CartMemento cartMemento) {
		items=cartMemento.getItems();
	}

	static class CartMemento {
		ArrayList<Item> items;

		public CartMemento(ArrayList<Item> items) {
			super();
			this.items = items;
		}

		private ArrayList<Item> getItems() {
			return items;
		}

	}

}
