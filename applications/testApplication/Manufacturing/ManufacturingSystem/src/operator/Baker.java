package operator;

import java.util.ArrayList;
import java.util.List;

import processedComponent.RawWidget;
import processedComponent.RoughWidget;

import com.object.Goo;
import com.object.Widget;
import com.pile.GooPile;
import com.pile.WidgetPile;

public class Baker implements Productor{

	private WidgetPile widgetPileObject = new WidgetPile();
	
	public RawWidget getRawWidget()
	{
		Widget wid= new RawWidget();
		//select the Widget from the WidgetPile
		wid = (Widget) widgetPileObject.retrieveSpecificWidgets("Raw");
		//remove the RawWidget from the Pile.
		return (RawWidget) wid; 
	}
	
	@Override
	public Object create(Object rawWid) {
		// TODO Auto-generated method stub
		RoughWidget roughWidget= new RoughWidget((RawWidget)rawWid);
		roughWidget.setStyle("Rough");
		// update
		remove(rawWid);
		add(roughWidget);
		return roughWidget;
	}

	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		widgetPileObject.add((Widget)obj);
	}

	@Override
	public void remove(Object obj) {
		widgetPileObject.remove((Widget)obj);
	}
}
