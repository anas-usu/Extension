package operator;

import processedComponent.PolishedWidget;
import processedComponent.RawWidget;
import processedComponent.RoughWidget;

import com.object.Widget;
import com.pile.WidgetPile;

public class Polisher implements Productor{

	int index=0;
	private RoughWidget roughWidget= new RoughWidget();
	
	public RoughWidget getRoughWidget()
	{
		Widget wid= new RoughWidget();
		//select the Widget from the WidgetPile
			// conditions: style is "Raw"  and the code start with "Raw"
		//remove the RawWidget from the Pile.
		for(Widget widget: WidgetPile.widgetPile)
		{
			if(widget.getStyle()=="Rough")
			{
				index= WidgetPile.widgetPile.indexOf(widget);
				wid= WidgetPile.widgetPile.get(index);
			}
		}
		return (RoughWidget) wid; 
	}
	
	@Override
	public Object create() {
		// TODO Auto-generated method stub
		PolishedWidget polishedWidget= new PolishedWidget(getRoughWidget());
		polishedWidget.setStyle("Polished");
		add(polishedWidget);
		return polishedWidget;
	}

	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		
		//update
		remove((Widget)obj);
		WidgetPile.widgetPile.add((Widget)obj);
	}

	@Override
	public void remove(Object obj) {
		// TODO Auto-generated method stub
		
		//WidgetPile.widgetPile.remove(index);
		WidgetPile.widgetPile.remove(obj);
	}	
}
