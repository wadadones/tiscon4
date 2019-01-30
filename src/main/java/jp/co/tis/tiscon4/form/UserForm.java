package jp.co.tis.tiscon4.form;

import jp.co.tis.tiscon4.common.code.JobType;
import jp.co.tis.tiscon4.common.code.TreatedType;
import nablarch.core.util.StringUtil;
import nablarch.core.validation.ee.Domain;
import nablarch.core.validation.ee.Required;

import javax.validation.constraints.AssertTrue;
import java.io.Serializable;

public class UserForm implements Serializable {

    private static final long serialVersionUID = 1L;



    /** 漢字性 */
    @Required
    @Domain("kanjiFamilyName")
    private String kanjiFamilyName;

    /** 漢字名 */
    @Required
    @Domain("kanjiFirstName")
    private String kanjiFirstName;



    /** カナ性 */
    @Required
    @Domain("kanaFamilyName")
    private String kanaFamilyName;

    /** カナ名 */
    @Required
    @Domain("kanaFirstName")
    private String kanaFirstName;


    /** 英字性 */
    @Required
    @Domain("alphabetFamilyName")
    private String alphabetFamilyName;

    /** 英字名 */
    @Required
    @Domain("alphabetFamilyName")
    private String alphabetFirstName;



    /** 性別 */
    @Required
    @Domain("gender")
    private String gender;

    /** 生年月日 */
    @Required
    @Domain("dateOfBirth")
    private String dateOfBirth;

    /** 郵便番号 */
    @Required
    @Domain("zipCode")
    private String zipCode;


    /** 住所1 */
    @Required
    @Domain("address1")
    private String address1;

    /** 住所2 */
    @Required
    @Domain("address2")
    private String address2;



    /** 自宅電話番号 */
    @Required
    @Domain("homePhoneNumber")
    private String homePhoneNumber;

    /** 携帯電話番号 */
    @Required
    @Domain("mobilePhoneNumber")
    private String mobilePhoneNumber;

    /** メールアドレス */
    @Required
    @Domain("emailAddress")
    private String emailAddress;

    /** 配偶者有無 */
    @Required
    @Domain("married")
    private String married;

    /** 所得金額 */
    @Required
    @Domain("income")
    private String income;

    /** 職業 */
    @Required
    @Domain("job")
    private String job;

    /** その他の職業 */
    @Domain("otherJob")
    private String otherJob;

    /** 治療歴有無 */
    @Required
    @Domain("treated")
    private String treated;

    /** 既往歴 */
    @Domain("medicalHistory")
    private String medicalHistory;


    public String getKanjiFamilyName() { return kanjiFamilyName; }

    public void setKanjiFamilyName(String kanjiFamilyName) { this.kanjiFamilyName = kanjiFamilyName; }


    public String getKanjiFirstName() { return kanjiFirstName; }

    public void setKanjiFirstName(String kanjiFirstName) { this.kanjiFirstName = kanjiFirstName; }




    public String getKanaFamilyName() { return kanaFamilyName; }

    public void setKanaFamilyName(String kanaFamilyName) { this.kanaFamilyName = kanaFamilyName; }


    public String getKanaFirstName() { return kanaFirstName; }

    public void setKanaFirstName(String kanaFirstName) { this.kanaFirstName = kanaFirstName; }





    public String getAlphabetFamilyName() {
        return alphabetFamilyName;
    }

    public void setAlphabetFamilyName(String alphabetFamilyName) {
        this.alphabetFamilyName = alphabetFamilyName;
    }


    public String getAlphabetFirstName() {
        return alphabetFirstName;
    }

    public void setAlphabetFirstName(String alphabetFirstName) {
        this.alphabetFirstName = alphabetFirstName;
    }





    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }




    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }




    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getOtherJob() {
        return otherJob;
    }

    public void setOtherJob(String otherJob) {
        this.otherJob = otherJob;
    }

    public String getTreated() {
        return treated;
    }

    public void setTreated(String treated) {
        this.treated = treated;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    /**
     * その他の職業欄が正しく入力されているかどうか判定する。
     * 職業で「その他（有職）」を選択し、その他の職業欄に何らかの値が入力された場合、正しく入力されたと判定する。
     *
     * @return その他の職業欄に入力がある場合にtrue
     */
    @AssertTrue(message = "{tiscon4.order.inputUser.error.hasValueOtherJob}")
    public boolean hasValueOtherJob() {
        if (StringUtil.isNullOrEmpty(job)) {
            // 職業が未入力の場合は、相関バリデーションは実施しない。(バリデーションOKとする)
            return true;
        } else if (JobType.EMPLOYED.getCode().equals(job) && StringUtil.isNullOrEmpty(otherJob)) {
            return false;
        }
        return true;
    }

    /**
     * 既往歴が正しく入力されているかどうか判定する。
     * 治療有無で「はい」を選択し、既往歴に何らかの値が入力された場合、正しく入力されたと判定する。
     *
     * @return 既往歴に入力がある場合にtrue
     */
    @AssertTrue(message = "{tiscon4.order.inputUser.error.hasValueMedicalHistory}")
    public boolean hasValueMedicalHistory() {
        if (StringUtil.isNullOrEmpty(treated)) {
            // 治療有無が未入力の場合は、相関バリデーションは実施しない。(バリデーションOKとする)
            return true;
        } else if (TreatedType.TREATED.getCode().equals(treated) && StringUtil.isNullOrEmpty(medicalHistory)) {
            return false;
        }
        return true;
    }

}
