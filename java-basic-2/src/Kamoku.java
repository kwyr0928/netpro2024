class Kamoku {
	String name;
	int score;
	int studentid;

	Kamoku(int s, int studentid) {  // これがコンストラクタ。特殊なメソッド。クラス名と同じ。
		score = s; 
		this.studentid = studentid;
	}

// setScore というメソッドを定義する。
// score に値を設定する。
	public void setScore(int num){
		score = num;
	}

// getScore というメソッドを定義する。
// scoreを返す。
	public int getScore() {
		return score;
	}


public int getStudentid() {
	return studentid;
}
}

// メソッド 関数のこと  
//   public 返り値(戻り値return value) 関数名() {
//      中に具体的な処理を書く
//  }
