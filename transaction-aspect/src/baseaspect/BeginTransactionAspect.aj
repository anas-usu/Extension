package baseaspect;

import org.apache.log4j.Logger;

import umjdt.joinpoints.BeginEventJP;



public abstract aspect BeginTransactionAspect extends TransactionAspect
{
	private Logger logger = Logger.getLogger(BeginTransactionAspect.class);

	public pointcut TransactionBegin(BeginEventJP _beginEventJp): execution(* BeginTransactionAspect.begin(..) && args(_beginEventJp));

	void around(BeginEventJP _beginEventJp) : (_beginEventJp)
	{											
		begin(_beginEventJp);
   
		proceed(_beginEventJp);
	}

	public void begin(BeginEventJP _beginEventJp)
	{		
	} 
}