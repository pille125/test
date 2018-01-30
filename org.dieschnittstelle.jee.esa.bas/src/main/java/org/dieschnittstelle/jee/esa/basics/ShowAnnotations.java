package org.dieschnittstelle.jee.esa.basics;


import org.dieschnittstelle.jee.esa.basics.annotations.AnnotatedStockItemBuilder;
import org.dieschnittstelle.jee.esa.basics.annotations.DisplayAs;
import org.dieschnittstelle.jee.esa.basics.annotations.StockItemProxyImpl;
import org.w3c.dom.Element;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.dieschnittstelle.jee.esa.utils.Utils.*;

public class ShowAnnotations {

	public static void main(String[] args) {
		// we initialise the collection
		StockItemCollection collection = new StockItemCollection(
				"stockitems_annotations.xml", new AnnotatedStockItemBuilder());
		// we load the contents into the collection
		collection.load();

		for (IStockItem consumable : collection.getStockItems()) {
			;
			showAttributes(((StockItemProxyImpl)consumable).getProxiedObject());
		}

		// we initialise a consumer
		Consumer consumer = new Consumer();
		// ... and let them consume
		consumer.doShopping(collection.getStockItems());
	}

	/*
	 * UE BAS2 
	 */
	private static void showAttributes(Object consumable) {
		String print_atts = "";
		for(Field attribute : consumable.getClass().getDeclaredFields()){
			DisplayAs value = attribute.getAnnotation(DisplayAs.class);
			final String attributeName;
			//if annotation is set, put that value as attribute name
			if(value != null && !value.getValue().isEmpty()){
				attributeName = value.getValue();
			}else{
				attributeName = attribute.getName();
			}
			String getterName = "get" + attributeName.substring(0,1).toUpperCase() + attributeName.substring(1);
            Method get = null;
            try {
                get = consumable.getClass().getDeclaredMethod(getterName);
            } catch (NoSuchMethodException e) {
                System.err.println("No getter " + getterName + " found.");
                e.printStackTrace();
            }
            if(get != null) {
				try {
					// Assume that attribute value can be .toString...if specific types toString is desired, then ask here for type
					print_atts += attributeName + ": " + get.invoke(consumable).toString() + ", ";
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		//cut off comma and space
		if(print_atts.endsWith(", ")) {
			print_atts = print_atts.substring(0, print_atts.length() - 2);
		}
		show("{" + consumable.getClass().getSimpleName() + " " + print_atts + "}");
	}

}
