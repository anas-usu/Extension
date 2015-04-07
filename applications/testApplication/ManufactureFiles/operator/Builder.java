package operator;

import java.util.ArrayList;
import java.util.List;

import processedComponent.RawWidget;

import com.object.Gadget;
import com.object.Goo;
import com.object.Widget;
import com.pile.GadgetPile;
import com.pile.GooPile;
import com.pile.WidgetPile;

public class Builder implements Productor{
	
	public String name; 
	public String type;
	public String code;
	public static List<Goo> goolist;
	RawWidget rawWidget;
	
	public Builder(){
	}
	
	public Goo getGoo()
	{
		Goo goo =new Goo();
		
		if(GooPile.gooPile.size() !=0)
		{
			goo = GooPile.gooPile.get(0);
			remove(goo);
		}
		return goo;
	}

	public List<Goo> getGooList()
	{
		int i =0;
		goolist= new ArrayList<Goo>();
		while(i<2)
		{
			i++;
			goolist.add(getGoo());
		}
		return goolist;
	}
	
	@Override
	public Object create() {
		rawWidget = new RawWidget(name, code, getGooList());
		add(rawWidget);
		return rawWidget;
	}
	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		
		// add new rawwidget to the widget pile table in DB
		WidgetPile.widgetPile.add(rawWidget);
	}
	
	@Override
	public void remove(Object obj) {
		// TODO Auto-generated method stub
		
		// remove the goo from the GooPile table in DB 
		for(Goo go : GooPile.gooPile)
		{
			if(go.equals(obj))
			{
				GooPile.gooPile.remove(go);
			}
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
