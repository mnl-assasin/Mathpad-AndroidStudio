package com.bulsu.mathpad.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bulsu.mathpad.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class FragmentQuiz2 extends Fragment {


    TextView question1,question2,question3,question4,question5,question6,question7,question8,question9,question10;
    RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7,rg8,rg9,rg10;
    RadioButton rb1_1,rb1_2,rb1_3,rb1_4;
    RadioButton rb2_1,rb2_2,rb2_3,rb2_4;
    RadioButton rb3_1,rb3_2,rb3_3,rb3_4;
    RadioButton rb4_1,rb4_2,rb4_3,rb4_4;
    RadioButton rb5_1,rb5_2,rb5_3,rb5_4;
    RadioButton rb6_1,rb6_2,rb6_3,rb6_4;
    RadioButton rb7_1,rb7_2,rb7_3,rb7_4;
    RadioButton rb8_1,rb8_2,rb8_3,rb8_4;
    RadioButton rb9_1,rb9_2,rb9_3,rb9_4;
    RadioButton rb10_1,rb10_2,rb10_3,rb10_4;
    ArrayList<RadioButton>arrRadioButton = new ArrayList<>();
    ArrayList<RadioGroup>arrRadioGroup = new ArrayList<>();
    ArrayList<TextView> arrQuestions = new ArrayList<>();
    ScrollView mScrollView;
    int retaking= 0 ;
    int score =0;

    int count1,count,count2;

    Button finish;
    Integer[] arrRandomNumber;
    boolean[] isChecked;
    View v;
    String [] arrQuestion,arrAnswer,arrUserAnswer,arrChoice1,arrChoice2,arrChoice3,arrChoice4;
    int arrSampleAnswer[];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fragment_quiz2, container, false);



        arrQuestion = new String[30];
        arrAnswer = new String[30];
        arrUserAnswer = new String[15];
        arrChoice1 = new String[30];
        arrChoice2 = new String[30];
        arrChoice3 = new String[30];
        arrChoice4 = new String[30];
        isChecked = new boolean[15];
        arrSampleAnswer = new int[15];

        setArrRandomNumber();
        setAllViews(v);
        mScrollView = (ScrollView) v.findViewById(R.id.scrollView1);

        //set number question only
//        for (int i =0;i<arrQuestion.length;i++)
//        {
//            arrQuestion[i] = "Question "+i;
//        }
        setQuestionsAndChoices();

        for (int i =0;i<15;i++)
        {
            arrQuestions.get(i).setText(arrQuestion[arrRandomNumber[i]]);
        }


        //setChoices
//        for (int i =0;i<arrChoice1.length;i++)
//        {
//            arrChoice1[i]="Choice "+i;
//            arrChoice2[i]="Choice "+i;
//            arrChoice3[i]="Choice "+i;
//            arrChoice4[i]="Choice "+i;
//        }



        while(count1<15)
        {

            arrRadioButton.get(count2).setText(arrChoice1[arrRandomNumber[count]]);
            arrRadioButton.get(count2).setTextColor(Color.YELLOW);
            count2++;

            arrRadioButton.get(count2).setText(arrChoice2[arrRandomNumber[count]]);
            arrRadioButton.get(count2).setTextColor(Color.YELLOW);
            count2++;

            arrRadioButton.get(count2).setText(arrChoice3[arrRandomNumber[count]]);
            arrRadioButton.get(count2).setTextColor(Color.YELLOW);
            count2++;

            arrRadioButton.get(count2).setText(arrChoice4[arrRandomNumber[count]]);
            arrRadioButton.get(count2).setTextColor(Color.YELLOW);
            count2++;

            count++;
            count1++;
        }

        setAllViews(v);



        count2=0;

        count=0;
        getUserAnswer();
        onClickDismiss(v);


        return v;
    }

    public void onClickDismiss(final View v)
    {
        finish = (Button) v.findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View view1 = LayoutInflater.from(getContext()).inflate(R.layout.score_dialog_layout,null);
                final AlertDialog myDialog = new AlertDialog.Builder(getContext()).setView(view1).setTitle("").create();
                final Button ok = (Button) view1.findViewById(R.id.button);
                final Button retake = (Button) view1.findViewById(R.id.button2);
                final TextView tv_score = (TextView) view1.findViewById(R.id.tv_score);
                myDialog.setCancelable(false);

                for (int i =0;i<15;i++)
                {
                    if (arrSampleAnswer[i]==1)
                    {
                        score++;
                    }
                }
                tv_score.setText(score+"/15");
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });

                if (retaking==1)
                {
                    retake.setEnabled(false);
                }

                retake.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int count1_1=15;
                        int count1_0=0;
                        int count1_2=0;
                        int count1_3=0;



                        arrQuestions.get(count1_0).setText(arrQuestion[arrRandomNumber[count1_1]]);
                        while (count1_1<30)
                        {
                            arrQuestions.get(count1_0).setText(arrQuestion[arrRandomNumber[count1_1]]);
                            count1_0++;
                            count1_1++;

                        }

                        count1_1=15;

                        arrRadioButton.get(0).setText(arrChoice4[arrRandomNumber[0]]);
                        count1_3=15;

                        for (int i=15;i<30;i++)
                        {
                            Log.d("kim","q12");
                            arrRadioButton.get(count1_2).setText(arrChoice1[arrRandomNumber[count1_3]]);
                            arrRadioButton.get(count1_2).setTextColor(Color.YELLOW);
                            arrRadioButton.get(count1_2).setChecked(false);
                            count1_2++;

                            arrRadioButton.get(count1_2).setText(arrChoice2[arrRandomNumber[count1_3]]);
                            arrRadioButton.get(count1_2).setTextColor(Color.YELLOW);
                            arrRadioButton.get(count1_2).setChecked(false);
                            count1_2++;

                            arrRadioButton.get(count1_2).setText(arrChoice3[arrRandomNumber[count1_3]]);
                            arrRadioButton.get(count1_2).setTextColor(Color.YELLOW);
                            arrRadioButton.get(count1_2).setChecked(false);
                            count1_2++;

                            arrRadioButton.get(count1_2).setText(arrChoice4[arrRandomNumber[count1_3]]);
                            arrRadioButton.get(count1_2).setTextColor(Color.YELLOW);
                            arrRadioButton.get(count1_2).setChecked(false);
                            count1_2++;
                            count1_3++;
                            count1_1++;

                        }
                        mScrollView.post(new Runnable() {
                            public void run() {
                                mScrollView.scrollTo(0, mScrollView.getTop());
                            }
                        });

                        retaking=1;
                        myDialog.dismiss();

                    }
                });

                myDialog.show();
                score=0;
            }
        });

    }


    public void setQuestionsAndChoices(){
        arrQuestion[0]= "The student council is selling flowers for mother’s day.  They bought 200 roses for $1.67 each, 150 daffodils for $1.03 each and 100 orchids for $2.59 each.  They sold the roses for $3.00 each, the daffodils for $2.25 each and the orchids for $4.50 each.";
        arrQuestion[1]="The first table shows points awarded by the judges at the New England Sheep and Wool Fair for each competition.  The second table shows the degree of difficulty of each piece.  ";
        arrQuestion[2]="A hardware store sells hammers for $3.00, Flashlights for $5, and Lanterns for $7.00.  Store A sold 10 hammers, 2 flashlights and 2 lanterns.   Store B sold 9 hammers, 14 flashlights and 5 lanterns.  Store C sold 8 hammers, 6 flashlights and 7 lanterns.";
        arrQuestion[3]="If A and B are non-zero square matrices, then AB = 0 implies";
        arrQuestion[4]="A is a unitary matrix. Then eigen value of A are";
        arrQuestion[5]="A is an upper triangular with all diagonal entries zero, then I+A is";
        arrQuestion[6]= "Let u, v, w be three non-zero vectors which are linearly independent, then";
        arrQuestion[7]="Let A and B are square matrices such that AB=I, then zero is an eigen value of";
        arrQuestion[8]="The eigen values of a skew-symmetric matrix are";
        arrQuestion[9]="Let x and y be solutions to a system of n homogeneous linear equations. If z = ax + b where a and b are numbers.";
        arrQuestion[10]="Let x and y be solutions to a system of n homogeneous linear equations. If z = ax + by where a and b are numbers";
        arrQuestion[11]="Consider a linear system of m equations in n variables, and let the rank of the augmented matrix be r: If the system has in.nitely many solutions, then:";
        arrQuestion[12]="Let A, B and C be n x n matrices with A invertible.";
        arrQuestion[13]="Let A and B denote n x n matrices.";
        arrQuestion[14]="Let A and B denote n x n matrices, and assume AB = I.";
        arrQuestion[15]="Let A denote an n x n matrix.";
        arrQuestion[16]="Suppose that AP = D where D is a diagonal matrix.";
        arrQuestion[17]="Let A be a diagonalizable n x n matrix.";
        arrQuestion[18]="Suppose that A and B are similar n x n matrices.";
        arrQuestion[19]="Let B and D denote two bases of an n-dimensional vector space V.";
        arrQuestion[20]="Let {u, v, w, z} be independent vectors in a vector space V.";
        arrQuestion[21]="Let {v1, v2, … , vn} be dependent, nonzero vectors in a vector space V.";
        arrQuestion[22]="Let Z be a hermitian matrix.";
        arrQuestion[23]="Let U be a subspace of a vector space V, and assume that U 0, V:";
        arrQuestion[24]="Let V be finite dimensional, and let T : be a linear operator with matrices with respect to ordered bases B and D of V.";
        arrQuestion[25]="A set of linear equations is represented by the matrix equation Ax = b. The necessary condition for the existence of a solution for this system is";
        arrQuestion[26]="The rank of a 3 x 3 matrix C (= AB), found by multiplying a non-zero column matrix A of size 3 x 1 and a non-zero row matrix B of size 1 x 3, is";
        arrQuestion[27]="The matrix B = AT, where A is any matrix is";
        arrQuestion[28]="Eigen values of a square symmetric matrix are always";
        arrQuestion[29]="If AT = A-1, where A is a real matrix, then A is";

        arrChoice1[0]="Organize the data in two matrices, and use matrix multiplication to find the total amount spent of the flowers.  ";
        arrChoice2[0]="Write two matrices, and use matrix multiplication to find the total amount the student council received for the flower sale.";
        arrChoice3[0]="Use matrix operations to find how much money the student council made on the project.";
        arrChoice4[0]="Find the total gross revenue from the flashlights sold at all three stores.";

        arrChoice1[1]="Create matrices to organize the given information.";
        arrChoice2[1]="Find the total score for each contestant.";
        arrChoice3[1]="Find the total gross revenue from the flashlights sold at all three stores.";
        arrChoice4[1]="Find this product. Hence state the company that John should hire the car from in order to save cost";

        arrChoice1[2]="Create a matrix for the Prices and a separate one for the Number of Items sold per store.";
        arrChoice2[2]="Find the product of the two matrices and explain in complete sentences what the product of the two matrices represents.";
        arrChoice3[2]="How would you find the total gross revenue from all three stores?";
        arrChoice4[2]="Find the total gross revenue from the flashlights sold at all three stores.";

        arrChoice1[3]="A and B are orthogonal";
        arrChoice2[3]="A and B are singular";
        arrChoice3[3]="B is singular";
        arrChoice4[3]="A is singular";

        arrChoice1[4]="1, -1";
        arrChoice2[4]="1, -i";
        arrChoice3[4]="i, -i";
        arrChoice4[4]="-1, i";

        arrChoice1[5]="invertible";
        arrChoice2[5]="idempotent";
        arrChoice3[5]="singular";
        arrChoice4[5]="nilpotent";

        arrChoice1[6]="u is linear combination of v and w";
        arrChoice2[6]="v is linear combination of u and w";
        arrChoice3[6]="w is linear combination of u and v";
        arrChoice4[6]="none of these";

        arrChoice1[7]="A but not of B";
        arrChoice2[7]="B but not of A";
        arrChoice3[7]="both A and B";
        arrChoice4[7]="neither A nor B";

        arrChoice1[8]="negative";
        arrChoice2[8]="real";
        arrChoice3[8]="absolute value of 1";
        arrChoice4[8]="purely imaginary or zero";

        arrChoice1[9]="z is a solution to the system for all a and b:";
        arrChoice2[9]="z is a solution only if a = 0 and b = 0:";
        arrChoice3[9]="The solution has n - 2 parameters.";
        arrChoice4[9]="There are at most 2 leading variables.";

        arrChoice1[10]="z is a solution to the system for all a and b:";
        arrChoice2[10]="z is a solution only if a = 0 and b = 0:";
        arrChoice3[10]="The solution has n - 2 parameters.";
        arrChoice4[10]="There are at most 2 leading variables.";

        arrChoice1[11]="The system is homogeneous.";
        arrChoice2[11]="r < m.";
        arrChoice3[11]="There are more variables than equations.";
        arrChoice4[11]="r < n.";

        arrChoice1[12]="If AB = CA then B = C.";
        arrChoice2[12]="If AB = AC then B = C.";
        arrChoice3[12]="The linear system Ax = 0 has nonzero solutions x.";
        arrChoice4[12]="ACA = 0 for some matrix C≠0.";

        arrChoice1[13]="If A and B are invertible and det A = det B; then A = B.";
        arrChoice2[13]="If rank A = n then A is invertible.";
        arrChoice3[13]="If A and B are invertible and rank A = rank B. then A = B.";
        arrChoice4[13]="A is a product of elementary matrices.";

        arrChoice1[14]="rank A < n.";
        arrChoice2[14]="BA = I.";
        arrChoice3[14]="Either A = I or B = I.";
        arrChoice4[14]="Either det A = 1 or det B = 1";

        arrChoice1[15]="If A x = 0 has only the trivial solution, then det A = 0.";
        arrChoice2[15]="If A x = 0 has a nontrivial solution, then det A = 0.";
        arrChoice3[15]="If A x = b has a solution for some b, then A is invertible.";
        arrChoice4[15]="If A 0 and A x = 0 then x = 0.";

        arrChoice1[16]="It can happen that D = 0 but A 0.";
        arrChoice2[16]="If D² = 2D then D = 2I.";
        arrChoice3[16]="If D² = D then A = I.";
        arrChoice4[16]="If D² = 0 then A = 0.";

        arrChoice1[17]="A is symmetric.";
        arrChoice2[17]="A² is not diagonalizable.";
        arrChoice3[17]="kA is diagonalizable for each scalar k.";
        arrChoice4[17]="A has distinct eigenvalues.";

        arrChoice1[18]="A and B have the same characteristic polynomial.";
        arrChoice2[18]="A = kB for some scalar k.";
        arrChoice3[18]="A = UB for some invertible matrix U.";
        arrChoice4[18]="A = UB for some vertible matrix U.";

        arrChoice1[19]="There is no vector in both B and D.";
        arrChoice2[19]="If there exists a vector in both B and D then B = D.";
        arrChoice3[19]="B and D contain the same number of vectors.";
        arrChoice4[19]="Some vector in B is also in D.";

        arrChoice1[20]="{u + v, v + w, w + z, z + u} spans V.";
        arrChoice2[20]="{u + v, v + w, w + z, z + u} is independent.";
        arrChoice3[20]="Span {u + v,v + w, w + z,z + u} is contained in span {u, v, w z}.";
        arrChoice4[20]="{u + v, v + w, w + z, z + u} is a basis of V.";

        arrChoice1[21]="There exists i≠j such that vi = kvj for some scalar k.";
        arrChoice2[21]="{v1} is dependent.";
        arrChoice3[21]="Span {v1, v2, …, vn} has dimension smaller than n.";
        arrChoice4[21]="{vi, vj} is independent for some i≠.";

        arrChoice1[22]="Z is unitary.";
        arrChoice2[22]="ZT = -Z.";
        arrChoice3[22]="i Z is hermitian.";
        arrChoice4[22]="Every eigenvalue of Z is real.";

        arrChoice1[23]="W and K are subspaces, then W = K";
        arrChoice2[23]="There exists a subspace W such UW = V.";
        arrChoice3[23]="There exists a subspace W such VW = V.";
        arrChoice4[23]="V=UU";

        arrChoice1[24]="B = UA for some invertible matrix U.";
        arrChoice2[24]="B = AT.";
        arrChoice3[24]="B = P-1AP for some invertible matrix P.";
        arrChoice4[24]="A and B are both invertible.";

        arrChoice1[25]="A must be invertible";
        arrChoice2[25]="b must be linearly depended on the columns of A";
        arrChoice3[25]="b must be linearly independent of the columns of A";
        arrChoice4[25]="None of these";

        arrChoice1[26]="0";
        arrChoice2[26]="1";
        arrChoice3[26]="2";
        arrChoice4[26]="3";

        arrChoice1[27]="skew symmetric";
        arrChoice2[27]="symmetric about the secondary diagona";
        arrChoice3[27]="always symmetric";
        arrChoice4[27]="another general matrix";

        arrChoice1[28]="positive";
        arrChoice2[28]="real and imaginary";
        arrChoice3[28]="negative";
        arrChoice4[28]="real";

        arrChoice1[29]="normal";
        arrChoice2[29]="symmetric";
        arrChoice3[29]="Hermitian";
        arrChoice4[29]="orthogonal";

    }


    public void copies()
    {
        arrQuestion[0]= "The student council is selling flowers for mother’s day.  They bought 200 roses for $1.67 each, 150 daffodils for $1.03 each and 100 orchids for $2.59 each.  They sold the roses for $3.00 each, the daffodils for $2.25 each and the orchids for $4.50 each.";
        arrQuestion[1]="The first table shows points awarded by the judges at the New England Sheep and Wool Fair for each competition.  The second table shows the degree of difficulty of each piece.  ";
        arrQuestion[2]="A hardware store sells hammers for $3.00, Flashlights for $5, and Lanterns for $7.00.  Store A sold 10 hammers, 2 flashlights and 2 lanterns.   Store B sold 9 hammers, 14 flashlights and 5 lanterns.  Store C sold 8 hammers, 6 flashlights and 7 lanterns.";
        arrQuestion[3]="The charges for hiring a car from three different companies, based on the number of days for which a car is hired and/or the number of kilometers for which the car is driven are as follows:  John needs to hire a car for 4 days to drive 560 kilometers.  Company A charges $66 per day.  \tCompany B charges 48 cents on per kilometer driven.  Company C charges $30 per day and 25 cents on per kilometer driven";
        arrQuestion[4]="A is a unitary matrix. Then eigen value of A are";
        arrQuestion[5]="A is an upper triangular with all diagonal entries zero, then I+A is";
        arrQuestion[6]= "Let u, v, w be three non-zero vectors which are linearly independent, then";
        arrQuestion[7]="Let A and B are square matrices such that AB=I, then zero is an eigen value of";
        arrQuestion[8]="The eigen values of a skew-symmetric matrix are";
        arrQuestion[9]="Let x and y be solutions to a system of n homogeneous linear equations. If z = ax + b where a and b are numbers.";
        arrQuestion[10]="";
        arrQuestion[11]="";
        arrQuestion[12]="";
        arrQuestion[13]="";
        arrQuestion[14]="";
        arrQuestion[15]="";
        arrQuestion[16]="";
        arrQuestion[17]="";
        arrQuestion[18]="";
        arrQuestion[19]="";
        arrQuestion[20]="";
        arrQuestion[21]="";
        arrQuestion[22]="";
        arrQuestion[23]="";
        arrQuestion[24]="";
        arrQuestion[25]="";
        arrQuestion[26]="";
        arrQuestion[27]="";
        arrQuestion[28]="";
        arrQuestion[29]="";



        arrChoice1[9]="";
        arrChoice2[9]="";
        arrChoice3[9]="";
        arrChoice4[9]="";

        arrChoice1[10]="";
        arrChoice2[10]="";
        arrChoice3[10]="";
        arrChoice4[10]="";

        arrChoice1[11]="";
        arrChoice2[11]="";
        arrChoice3[11]="";
        arrChoice4[11]="";

        arrChoice1[12]="";
        arrChoice2[12]="";
        arrChoice3[12]="";
        arrChoice4[12]="";

        arrChoice1[13]="";
        arrChoice2[13]="";
        arrChoice3[13]="";
        arrChoice4[13]="";

        arrChoice1[14]="";
        arrChoice2[14]="";
        arrChoice3[14]="";
        arrChoice4[14]="";

        arrChoice1[15]="";
        arrChoice2[15]="";
        arrChoice3[15]="";
        arrChoice4[15]="";

        arrChoice1[16]="";
        arrChoice2[16]="";
        arrChoice3[16]="";
        arrChoice4[16]="";

        arrChoice1[17]="";
        arrChoice2[17]="";
        arrChoice3[17]="";
        arrChoice4[17]="";

        arrChoice1[18]="";
        arrChoice2[18]="";
        arrChoice3[18]="";
        arrChoice4[18]="";

        arrChoice1[19]="";
        arrChoice2[19]="";
        arrChoice3[19]="";
        arrChoice4[19]="";

        arrChoice1[20]="";
        arrChoice2[20]="";
        arrChoice3[20]="";
        arrChoice4[20]="";

        arrChoice1[21]="";
        arrChoice2[21]="";
        arrChoice3[21]="";
        arrChoice4[21]="";

        arrChoice1[22]="";
        arrChoice2[22]="";
        arrChoice3[22]="";
        arrChoice4[22]="";

        arrChoice1[23]="";
        arrChoice2[23]="";
        arrChoice3[23]="";
        arrChoice4[23]="";

        arrChoice1[24]="";
        arrChoice2[24]="";
        arrChoice3[24]="";
        arrChoice4[24]="";

        arrChoice1[25]="";
        arrChoice2[25]="";
        arrChoice3[25]="";
        arrChoice4[25]="";

        arrChoice1[26]="";
        arrChoice2[26]="";
        arrChoice3[26]="";
        arrChoice4[26]="";

        arrChoice1[27]="";
        arrChoice2[27]="";
        arrChoice3[27]="";
        arrChoice4[27]="";

        arrChoice1[28]="";
        arrChoice2[28]="";
        arrChoice3[28]="";
        arrChoice4[28]="";

        arrChoice1[29]="";
        arrChoice2[29]="";
        arrChoice3[29]="";
        arrChoice4[29]="";
    }

    public void setAllViews(View v)
    {
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg1));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg2));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg3));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg4));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg5));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg6));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg7));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg8));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg9));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg10));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg11));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg12));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg13));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg14));
        arrRadioGroup.add((RadioGroup) v.findViewById(R.id.rg15));

        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton1));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton2));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton3));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton4));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton5));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton6));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton7));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton8));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton9));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton10));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton11));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton12));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton13));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton14));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton15));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton16));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton17));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton18));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton19));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton20));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton21));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton22));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton23));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton24));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton25));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton26));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton27));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton28));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton29));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton30));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton31));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton32));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton33));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton34));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton35));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton36));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton37));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton38));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton39));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton40));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton41));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton42));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton43));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton44));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton45));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton46));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton47));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton48));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton49));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton50));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton51));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton52));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton53));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton54));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton55));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton56));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton57));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton58));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton59));
        arrRadioButton.add((RadioButton) v.findViewById(R.id.radioButton60));

        arrQuestions.add((TextView) v.findViewById(R.id.q1));
        arrQuestions.add((TextView) v.findViewById(R.id.q2));
        arrQuestions.add((TextView) v.findViewById(R.id.q3));
        arrQuestions.add((TextView) v.findViewById(R.id.q4));
        arrQuestions.add((TextView) v.findViewById(R.id.q5));
        arrQuestions.add((TextView) v.findViewById(R.id.q6));
        arrQuestions.add((TextView) v.findViewById(R.id.q7));
        arrQuestions.add((TextView) v.findViewById(R.id.q8));
        arrQuestions.add((TextView) v.findViewById(R.id.q9));
        arrQuestions.add((TextView) v.findViewById(R.id.q10));
        arrQuestions.add((TextView) v.findViewById(R.id.q11));
        arrQuestions.add((TextView) v.findViewById(R.id.q12));
        arrQuestions.add((TextView) v.findViewById(R.id.q13));
        arrQuestions.add((TextView) v.findViewById(R.id.q14));
        arrQuestions.add((TextView) v.findViewById(R.id.q15));

    }

    public void setArrRandomNumber()
    {
        arrRandomNumber = new Integer[30];

        for (int i = 0; i < arrRandomNumber.length; i++) {
            arrRandomNumber[i] = i;
        }

        Collections.shuffle(Arrays.asList(arrRandomNumber));
    }


    public void getUserAnswer()
    {
        arrRadioGroup.get(0).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[0] = checkedRadioButton.isChecked();
                if (isChecked[0])
                {
                    arrUserAnswer[count]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[0]=radioGroup.indexOfChild(checkedRadioButton);
                }
            }
        });
        arrRadioGroup.get(1).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[1] = checkedRadioButton.isChecked();
                if (isChecked[1])
                {
                    arrUserAnswer[1]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[1]=radioGroup.indexOfChild(checkedRadioButton);
                }
            }
        });
        arrRadioGroup.get(2).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[2] = checkedRadioButton.isChecked();
                if (isChecked[2])
                {
                    arrUserAnswer[2]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[2]=radioGroup.indexOfChild(checkedRadioButton);

                }
            }
        });
        arrRadioGroup.get(3).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[3] = checkedRadioButton.isChecked();
                if (isChecked[3])
                {
                    arrUserAnswer[3]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[3]=radioGroup.indexOfChild(checkedRadioButton);
                }
            }
        });
        arrRadioGroup.get(4).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[4] = checkedRadioButton.isChecked();
                if (isChecked[4])
                {
                    arrUserAnswer[4]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[4]=radioGroup.indexOfChild(checkedRadioButton);

                }
            }
        });
        arrRadioGroup.get(5).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[5] = checkedRadioButton.isChecked();
                if (isChecked[5])
                {
                    arrUserAnswer[5]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[5]=radioGroup.indexOfChild(checkedRadioButton);
                }
            }
        });
        arrRadioGroup.get(6).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[6] = checkedRadioButton.isChecked();
                if (isChecked[6])
                {
                    arrUserAnswer[6]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[6]=radioGroup.indexOfChild(checkedRadioButton);
                }
            }
        });
        arrRadioGroup.get(7).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
            isChecked[7] = checkedRadioButton.isChecked();
            if (isChecked[7])
            {
                arrUserAnswer[7]=checkedRadioButton.getText().toString();
                arrSampleAnswer[7]=radioGroup.indexOfChild(checkedRadioButton);
            }
        }
        });
        arrRadioGroup.get(8).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[8] = checkedRadioButton.isChecked();
                if (isChecked[8])
                {
                    arrUserAnswer[8]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[8]=radioGroup.indexOfChild(checkedRadioButton);
                }
            }
        });
        arrRadioGroup.get(9).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[9] = checkedRadioButton.isChecked();
                if (isChecked[9])
                {
                    arrUserAnswer[9]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[9]=radioGroup.indexOfChild(checkedRadioButton);
                }
            }
        });
        arrRadioGroup.get(10).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[10] = checkedRadioButton.isChecked();
                if (isChecked[10])
                {
                    arrUserAnswer[10]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[10]=radioGroup.indexOfChild(checkedRadioButton);
                }
            }
        });
        arrRadioGroup.get(11).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[11] = checkedRadioButton.isChecked();
                if (isChecked[11])
                {
                    arrUserAnswer[11]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[11]=radioGroup.indexOfChild(checkedRadioButton);
                }
            }
        });
        arrRadioGroup.get(12).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[12] = checkedRadioButton.isChecked();
                if (isChecked[12])
                {
                    arrUserAnswer[12]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[12]=radioGroup.indexOfChild(checkedRadioButton);
                }
            }
        });
        arrRadioGroup.get(13).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[13] = checkedRadioButton.isChecked();
                if (isChecked[13])
                {
                    arrUserAnswer[13]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[13]=radioGroup.indexOfChild(checkedRadioButton);
                }
            }
        });
        arrRadioGroup.get(14).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                isChecked[14] = checkedRadioButton.isChecked();
                if (isChecked[14])
                {
                    arrUserAnswer[14]=checkedRadioButton.getText().toString();
                    arrSampleAnswer[14]=radioGroup.indexOfChild(checkedRadioButton);
                }
            }
        });
    }
}
