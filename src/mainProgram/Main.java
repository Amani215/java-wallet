package mainProgram;

import ui.*;

public class Main {
	public static void main(String[] args) {
		//show the main window
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		/*
    int x;
    do{
        scanf("%d",&x);
        switch (x){
            case 1: entry("wallet.txt",x);
                    break;
            case 2: entry("wallet.txt",x);
                    break;
            case 3: add_category("category.txt");
                    break;
            case 4: printf("    Total of incomes: %.2lf\n",total("wallet.txt",1));
                    printf("    Total of expenses: %.2lf\n",total("wallet.txt",2));
                    printf("    Most expensive category: ");
                    cat_name(max_expense("wallet.txt"));
                    printf("    Overall balance: %.2lf\n\n", total("wallet.txt",1)-total("wallet.txt",2));
                    break;
            case 5: statistics();
                    break;
            case 0: return 0;
            default: break;
        }
    }while (x!=0);

    return 0;
}*/
	}
}

/*FUNCTIONS*/

/*"Add Category" lines of code*/

/*void showf(char* filename){ /*prints the content of the file*/

        /*open file*/
   /* FILE* fp=fopen(filename,"rt");
    if (fp==NULL) return;

        /*variable declarations*/
  /*  int id,status;
    char categ[20];

    /*printing the content of the file*/
 /*   while (fscanf(fp,"%d,%s",&id,categ)==2){
        printf("%d,%s\n",id,categ);
    }

        /*close file*/
 /*   status=fclose(fp);
    if(status!=0) return;
}

int last_cat(char* filename){ /*returns the number of the last category in the database*/

        /*open file*/
  /*  FILE* fp=fopen(filename,"rt");
    if (fp==NULL) return -1;

        /*variable declarations*/
 /*   int status,id,lastcat=0;
    char categ[20];

        /*counting the number of categories from the file*/
   /* while (fscanf(fp,"%d,%s",&id,categ)==2)
        lastcat++;

        /*close file*/
    /*status=fclose(fp);
    if (status!=0) return -1;

    return lastcat;
}

int cat_exist(char* cat){ /*verifies if the name of a category is already in the database or not*/

        /*open file*/
    /*FILE* fp=fopen("category.txt","rt");
    if (fp==NULL) return -1;

        /*variable declarations*/
    /*int status,id;
    char categ[20];

        /*verification*/
    /*while (fscanf(fp,"%d,%s",&id,categ)==2)
        if (strcmp(cat,categ)==0) return 1;

        /*close file*/
    /*status=fclose(fp);
    if (status!=0) return -1;

        /*category not in the database*/
    /*return 0;
}

void add_category(char* filename){ /*add a new category line to the database*/

        /*open file*/
    /*FILE* fp=fopen(filename,"a");
    if (fp==NULL) return;

        /*variable declarations*/
/*    int status;
    char categ[20];

        /*ask the user for the category name*/
  /*  do{
      printf("Please give the name of the new category: ");
      scanf("%s",categ);
      if (cat_exist(categ)==1)
        printf("This name exists in the database\n");
    }while(cat_exist(categ)==1);

        /*add the category to the database*/
    /*if (last_cat(filename)!=-1){
        int id=last_cat(filename)+1;
        fprintf(fp,"%d,%s\n",id,categ);
    }

        /*close file*/
  /*  status=fclose(fp);
    if (status!=0) return;
}

/*"Add income" and "subtract expense" lines of codes*/

/*int verify_date(int day,int month,int year){ /*returns 0 if the date is invalid and 1 if it's valid*/

        /*verify the day*/
  /*  if ((day<1)||(day>31)) day=0; else day=1;

        /*verify the month*/
    /*if ((month<1)||(month>12)) month=0; else month=1;

        /*verify the year*/
    /*if ((year>2020)||(year<0)) year=0; else year=1;

    return (day*month*year);
}

void entry(char* filename,int x){ /*adds a new entry to a file: x=1 for income entry and x=2 for an expense entry*/

        /*open file*/
    /*FILE* fp=fopen(filename,"a");
    if (fp==NULL) return;

        /*variable declarations*/
    /*double amount;
    int day,month,year,id,status;

        /*ask the user for the amount*/
    /*printf("Please give the amount: ");
    scanf("%lf",&amount);

    if (x==2) amount = -amount;

        /*ask the user for the date*/
    /*do{
      printf("please give the day, the month and the year: ");
      scanf("%d %d %d",&day,&month,&year);
    }while (verify_date(day,month,year)==0);

        /*ask the user for the category of the entry*/
    /*printf("The categories are:\n");
    showf("category.txt");
    do{
      printf("Enter the number corresponding to your category ");
      scanf("%d",&id);
      if((id<1)||(id>last_cat("category.txt"))){
             printf("Do you want to add a category? Press 1 if yes or any other number if no ");
             int x;
             scanf("%d",&x);
             if (x==1) add_category("category.txt");
         }
    }while((id<1)||(id>last_cat("category.txt")));

        /*add the entry to the file*/
    /*fprintf(fp,"%.2lf,%d/%d/%d,%d\n",amount,day,month,year,id);

        /*close file*/
    /*status=fclose(fp);
    if (status!=0) return;
}

/*"Money in my wallet" lines of code*/

/*double total(char* filename,int x){ /*calculates the total (from the file)of all incomes if x=1 and the total of all expenses if x=2*/

        /*open file*/
  /*  FILE* fp=fopen(filename,"rt");
    if (fp==NULL) return -1;

        /*variable declarations*/
    /*double sum=0,amount;
    int day,month,year,id,status;

        /*calculate the total from the file*/
    /*while (fscanf(fp,"%lf,%d/%d/%d,%d",&amount,&day,&month,&year,&id)==5){
        if ((x==1)&&(amount>0)) sum=sum+amount;
       else
        if ((x==2)&&(amount<0)) sum=sum-amount;
    }

        /*close file*/
    /*status=fclose(fp);
    if (status!=0) return -1;

    return (sum);
}

int max_expense(char* filename){/*returns the ID of the most expensive category*/

        /*open file*/
 /*  FILE *fp=fopen(filename,"rt");
   if (fp==NULL) return 0;

   int day, month, year, id, max=0, status, lastcat=last_cat("category.txt");
   double amount, *tab;

        /*allocating memory and initializing the array to 0*/
   /*tab=(double*)malloc(lastcat*sizeof(double));
   for (int i=0; i<lastcat; i++)
        tab[i]=0;

        /*fill the array with expenses from the file*/
 /*  while (fscanf(fp,"%lf,%d/%d/%d,%d",&amount,&day,&month,&year,&id)==5){
        if (amount<0)
            tab[id-1]=tab[id-1]-amount;
   }

        /*search for the number of the category with the largest expenses*/
 /*  for (int i=1; i<lastcat; i++)
        if (tab[i]>tab[max])
            max=i;

        /*free the allocated memory*/
 /*  for(int i=0; i<lastcat; i++)
        free(tab+i);
   free(tab);

        /*close file*/
 /*  status=fclose(fp);
   if (status!=0) return 0;

   return (max+1);
}

void cat_name(int x){/*prints the name of the category number x*/

        /*open file*/
   /* FILE*fp=fopen("category.txt","rt");
    if (fp==NULL) return;

        /*variable declarations*/
  /*  int status,id;
    char categ[20];

        /*search and print the name*/
  /*  while (fscanf(fp,"%d,%s",&id,categ)==2){
        if (id==x)
            printf("%s\n",categ);
    }

        /*close file*/
   /* status=fclose(fp);
    if (status!=0) return;
}

/*"Statistics" option lines of code*/

/*int compare_dates(date date1, date date2){/* returns 1 if d1>d2, 0 if d1=d2, -1 if d1<d2*/

/*     if (date1.year < date2.year) return -1;
    else
     if (date1.year > date2.year) return 1;

    if (date1.year == date2.year){
         if (date1.month < date2.month) return -1;
        else
         if (date1.month > date2.month) return 1;
        else
         if (date1.day < date2.day) return -1;
        else
         if(date1.day > date2.day) return 1;
        else
         return 0;
    }

        /*impossible case*/
  /*  return -2;
}

void ask_for_dates(date* date1, date*date2){/*asks the user to enter suitable dates*/

 /*  do{
       do{
        printf("Please give the starting date\n");
        scanf("%d %d %d",&(date1->day),&(date1->month),&(date1->year));
       }while (verify_date(date1->day,date1->month,date1->year)==0);

       do{
        printf("Please give the ending date\n");
        scanf("%d %d %d",&(date2->day),&(date2->month),&(date2->year));
       }while (verify_date(date2->day,date2->month,date2->year)==0);
   }while (compare_dates(*date1,*date2)!=-1);

   return;
}

void statistics(){
        /*open the file*/
/*    FILE*fp=fopen("wallet.txt","rt");
    if (fp==NULL) return;

        /*variable declarations*/
/*    int status, id, lastcat=last_cat("category.txt");
    date date1, date2, date3, dates[lastcat];
    double amount, **categories;

        /*in the "categories" 2d array row 0 is for the expenses, row 1 is for incomes and row 2 is for the largest expense*/

  /*  categories=(double**)malloc(lastcat*sizeof(double));
    for(int i=0; i<lastcat; i++){
        categories[i]=(double*)malloc(3*sizeof(double));
    }

        /*initialize the income and expenses for all categories to 0*/
  /*  for (int i = 0; i < lastcat;i++)
        for (int j=0; j<3; j++)
            categories[i][j] = 0;

        /*ask the user to specify the period*/
    /*ask_for_dates(&date1,&date2);

    for (int i=0; i<lastcat; i++){
        dates[i].day=0;
        dates[i].month=0;
        dates[i].year=0;
    }

        /*while reading from the file*/
  /*  while (fscanf(fp,"%lf,%d/%d/%d,%d",&amount,&date3.day,&date3.month,&date3.year,&id)==5){

        /*test if the amount is an expense and if the date is in the right specified period*/
    /*       if((amount<0)&&(compare_dates(date3,date1)==1)&&(compare_dates(date3,date2)==-1)){
                  categories[id-1][0]-=amount;
                  if (categories[id-1][2]<-amount){
                    categories[id-1][2]=-amount;
                    dates[id-1].day = date3.day;
                    dates[id-1].month = date3.month;
                    dates[id-1].year = date3.year;

                  }
           }
           else
        /* test if the amount is an income and if the date is in the right specified period*/
      /*     if ((amount>0)&&(compare_dates(date3,date1)==1)&&(compare_dates(date3,date2)==-1))
                categories[id-1][1]+=amount;
            }

        /*show the income and expense for each category in the period between d1 and d2*/
   /* for(int i=0; i<lastcat; i++){
                    printf("Category %d: ",i+1);
                    cat_name(i+1);
                    printf("      Amount earned: %.2lf\n",categories[i][1]);
                    printf("      Amount spent: %.2lf\n",categories[i][0]);
                    if (dates[i].day!=0)
                      printf("      The largest expense: %.2lf on %d/%d/%d\n\n",categories[i][2],dates[i].day,dates[i].month,dates[i].year);
                    else
                      printf("      No expense\n\n");
    }

        /*free the memory allocated for the "categories" array*/
   /* for (int i = 0; i < lastcat; i++){
        double* CurrentCat = categories[i];
        free(CurrentCat);
    }

        /*close the file*/
   /* status=fclose(fp);
    if (status!=0) return;
}*/
