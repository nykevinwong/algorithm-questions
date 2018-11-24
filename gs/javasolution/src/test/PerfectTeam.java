package test;

import java.util.HashMap;

public class PerfectTeam {

    public static int getSkillIndex(char c)
    {
        char[] skill = new char[] {'p','c','m','b','z'};

        for(int i=0;i<skill.length;i++)
            if(skill[i]==c) return i;

            return -1; // skill not founds
    }

    // a valid team requires of 5 skills each
    public static boolean isValidTeamExist(int[] skillCount)
    {
        for(int i=0;i<skillCount.length;i++)
            if(skillCount[i]<=0) return false;
        return true;
    }

    public static int getTeamGroup(String skillers)
    {
        char[] s = skillers.toCharArray();
        int[] skillCount = new int[5];


        for(int i=0;i<s.length;i++)
        {
            int skillIndex = getSkillIndex(s[i]);
            skillCount[skillIndex]++;
        }

        // calculate the team count
        int teamCount = 0;
        while(isValidTeamExist(skillCount))
        {
            // remove each student possessed with one skill
            for(int i=0;i<skillCount.length;i++)
                skillCount[i]--;

            teamCount++;
        }

        return  teamCount;
    }

    public static void main(String[] args) {

        System.out.println("The team group count:" + getTeamGroup("pcmbz"));
        System.out.println("The team group count:" + getTeamGroup("pcmbzpcmbz"));
        System.out.println("The team group count:" + getTeamGroup("pcmbzpcmbzzbcmp"));
        System.out.println("The team group count:" + getTeamGroup("pcmbzcbm"));
    }

}

