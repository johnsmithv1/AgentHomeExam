package se.ltu.softeng.dragon.monster;

/**
 * Class representing a Dragon monster
 * @author cm
 *
 */
public class Dragon extends Monster{
	
	/**
	 * Constructor for the Dragon
	 * @param sName Name of the dragon 
	 * @param iAttackDamage Damage of the dragon when he attacks the player once
	 */
	public Dragon(String sName, int iAttackDamage)
	{
		this.setsName(sName);
		this.setiAttackDamage(iAttackDamage);
		this.setiHealth(18);
		this.setsWelcomeMessage(

				"                                                  .~))>>\n"+
				"                                                 .~)>>\n"+
				"                                               .~))))>>>\n"+
				"                                             .~))>>             ___\n"+
				"                                           .~))>>)))>>      .-~))>>\n"+
				"                                         .~)))))>>       .-~))>>)>\n"+
				"                                       .~)))>>))))>>  .-~)>>)>\n"+
				"                   )                 .~))>>))))>>  .-~)))))>>)>\n"+
				"                ( )@@*)             //)>))))))  .-~))))>>)>\n"+
				"              ).@(@@               //))>>))) .-~))>>)))))>>)>\n"+
				"            (( @.@).              //))))) .-~)>>)))))>>)>\n"+
				"          ))  )@@*.@@ )          //)>))) //))))))>>))))>>)>\n"+
				"       ((  ((@@@.@@             |/))))) //)))))>>)))>>)>\n"+
				"      )) @@*. )@@ )   (\\_(\\-\\b  |))>)) //)))>>)))))))>>)>\n"+
				"    (( @@@(.@(@ .    _/`-`  ~|b |>))) //)>>)))))))>>)>\n"+
				"     )* @@@ )@*     (@)  (@) /\\b|))) //))))))>>))))>>\n"+
				"   (( @. )@( @ .   _/  /    /  \\b)) //))>>)))))>>>_._\n"+
				"    )@@ (@@*)@@.  (6///6)- / ^  \\b)//))))))>>)))>>   ~~-.\n"+
				" ( @jgs@@. @@@.*@_ VvvvvV//  ^  \\b/)>>))))>>      _.     `bb\n"+
				" ((@@ @@@*.(@@ . - | o |' \\ (  ^   \\b)))>>        .'       b`,\n"+
				"   ((@@).*@@ )@ )   \\^^^/  ((   ^  ~)_        \\  /           b `,\n"+
				"     (@@. (@@ ).     `-'   (((   ^    `\\ \\ \\ \\ \\|             b  `.\n"+
				"       (*.@*              / ((((        \\| | |  \\       .       b `.\n"+
				"                         / / (((((  \\    \\ /  _.-~\\     Y,      b  ;\n"+
				"                        / / / (((((( \\    \\.-~   _.`\" _.-~`,    b  ;\n"+
				"                       /   /   `(((((()    )    (((((~      `,  b  ;\n"+
				"                     _/  _/      `\"\"\"/   /'                  ; b   ;\n"+
				"                 _.-~_.-~           /  /'                _.'~bb _.'\n"+
				"               ((((~~              / /'              _.'~bb.--~\n"+
				"                                  ((((          __.-~bb.-~\n"+
				"                                              .'  b .~~\n"+
				"                                              :bb ,' \n"+
				"                                              ~~~~\n"
			);
		
	}

}
