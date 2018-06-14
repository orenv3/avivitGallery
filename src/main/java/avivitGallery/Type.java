package avivitGallery;

public enum Type {

	SPRING, WINTER, SUMMERTIME, AUTUMN, NO_TYPE;

	public Enum ToEnum(String type) {
		switch (type) {
		case "SPRING":
			return SPRING;
		case "WINTER":
			return WINTER;
		case "SUMMERTIME":
			return SUMMERTIME;
		case "AUTUMN":
			return AUTUMN;

		default:
			break;
		}
		return NO_TYPE;
	}
}
