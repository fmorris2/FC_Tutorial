package scripts.fc.missions.fctutorial.tasks.master_chef;

import org.tribot.api.Timing;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class MasterChefExit extends Task
{
	private static final long serialVersionUID = -799592653941981580L;
	
	private ABC2Reaction reaction = new ABC2Reaction(false, 3500);

	@Override
	public boolean execute()
	{
		if(new ClickObject("Open", "Door", new RSArea(new RSTile(3071, 3092, 0), new RSTile(3074, 3088, 0))).execute())
		{
			reaction.start();
			if(Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 180), 5000))
			{
				reaction.react();
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 180;
	}

	@Override
	public String getStatus()
	{
		return "Click door";
	}

}
