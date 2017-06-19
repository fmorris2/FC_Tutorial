package fctutorial;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Ending;
import org.tribot.script.interfaces.Painting;
import org.tribot.script.interfaces.Starting;

import scripts.fc.framework.mission.Mission;
import scripts.fc.framework.paint.FCPaintable;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.missions.fctutorial.FCTutorial;

@ScriptManifest(
		authors     = { 
		    "Final Calibur",
		}, 
		category    = "Tools", 
		name        = "FC Tutorial", 
		version     = 0.1, 
		description = "Tut Island", 
		gameMode    = 1)

public class FCTutorialScript extends FCMissionScript implements FCPaintable, Painting, Starting, Ending
{

	@Override
	protected Queue<Mission> getMissions()
	{
		return new LinkedList<>(Arrays.asList(new FCTutorial(this)));
	}

	@Override
	protected String[] scriptSpecificPaint()
	{
		return new String[0];
	}

}
