package dk.card;

public class RuleOfComparateCard implements Rule {

	@Override
	//�Ƚ�����Ƶ����Ϸ����
	public int compare(Player o1,Player o2){
		return o1.getMax().compareTo(o2.getMax());
	}

}
