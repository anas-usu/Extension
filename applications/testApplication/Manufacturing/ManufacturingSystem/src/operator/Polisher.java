package operator;

import processedComponent.PolishedWidget;
import processedComponent.RawWidget;
import processedComponent.RoughWidget;

import com.object.Widget;
import com.pile.WidgetPile;


public class Polisher implements Productor{

	private WidgetPile widgetPileObject = new WidgetPile();
	
	public RoughWidget getRoughWidget()
	{
		Widget wid= new Widget();
		//select the Widget from the WidgetPile
		wid = (Widget) widgetPileObject.retrieveSpecificWidgets("Rough");
		return (RoughWidget) wid; 
	}
	
	@Override
	public Object create(Object roughWid) {
		// TODO Auto-generated method stub
		PolishedWidget polishedWidget= new PolishedWidget((RoughWidget)roughWid);//getRoughWidget());
		polishedWidget.setStyle("Polished");
		//update
		remove(roughWid);
		add(polishedWidget);
		return polishedWidget;
	}

	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		widgetPileObject.add((Widget)obj);
	}

	@Override
	public void remove(Object obj) {
		// TODO Auto-generated method stub
		
		//WidgetPile.widgetPile.remove(index);
		widgetPileObject.remove(obj);
	}	
}
