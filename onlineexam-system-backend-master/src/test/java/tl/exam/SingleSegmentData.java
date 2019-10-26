package tl.exam;

import com.deepoove.poi.config.Name;

public class SingleSegmentData {

	@Name("single_name")
    private String singleName;
	@Name("single_content")
    private String singleContent;

	public String getSingleName() {
		return singleName;
	}

	public void setSingleName(String singleName) {
		this.singleName = singleName;
	}

	public String getSingleContent() {
		return singleContent;
	}

	public void setSingleContent(String singleContent) {
		this.singleContent = singleContent;
	}
}
