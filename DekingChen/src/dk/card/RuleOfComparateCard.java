package dk.card;

public class RuleOfComparateCard implements Rule {

	@Override
	//比较最大牌点的游戏规则
	public int compare(Player o1,Player o2){
		return o1.getMax().compareTo(o2.getMax());
	}

}
