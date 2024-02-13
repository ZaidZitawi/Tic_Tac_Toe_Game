package com.example.algo_p4;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HelloApplication extends Application {
    private TextArea player1Info = new TextArea();
    private TextArea roundInfo = new TextArea();
    private TextArea player2Info = new TextArea();
    private int roundNumber = 1;
    private int totalrounds;
    private Player player1;
    private Player player2;
    private TextArea textArea;
    private GridPane gridPane;
    private char[][] board = new char[3][3];
    private final char PLAYER_X = 'X';
    private final char PLAYER_O = 'O';
    private final char EMPTY = ' ';
    String flag1= "Win";
    String flag2= "Lose";
    String flag3= "Draw";
    AnchorPane lap2;
    AnchorPane lap1;
    Button twoplayersbtn;
    private boolean isHumanVsComputerMode=false;
    // Add a flag to track if it's AI mode or two-player mode
    private boolean isAIMode = false; // You can set this flag when the mode is switched
    private char currentPlayer = PLAYER_X;//for the 2 players mode

    String style = "-fx-control-inner-background:#ADD8E6; " + "-fx-font-size: 14px; " +
            "-fx-border-color: black; " + "-fx-border-width: 2; " + "-fx-border-radius: 10; " +
            "-fx-background-radius: 10;";

    String LabelStyle = "-fx-font-size: 18; -fx-font-weight: bold;";
    String btnStyle1="-fx-min-width: 100; -fx-border-color: purple; -fx-text-fill: purple; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;";
    String btnStyle="-fx-min-width: 100; -fx-border-color: red; -fx-text-fill: red; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;";
    String ButtonStyle2 = "-fx-background-color:#0598ff; -fx-background-color:transparent; -fx-font-size: 13; -fx-font-weight: bold;";
    Image one = new Image("C:\\Users\\DELL\\IdeaProjects\\Algo_P4\\src\\main\\java\\Images\\img.png");
    Image two = new Image("C:\\Users\\DELL\\IdeaProjects\\Algo_P4\\src\\main\\java\\Images\\img_1.png");
    Image three = new Image("C:\\Users\\DELL\\IdeaProjects\\Algo_P4\\src\\main\\java\\Images\\img_2.png");
    Image start = new Image("C:\\Users\\DELL\\IdeaProjects\\Algo_P1\\src\\main\\java\\images\\img_6.png");
    Image reset = new Image("C:\\Users\\DELL\\IdeaProjects\\Algo_P4\\src\\main\\java\\Images\\reset.png");
    Image close = new Image("C:\\Users\\DELL\\IdeaProjects\\Algo_P1\\src\\main\\java\\images\\img_5.png");
    Image icon = new Image("C:\\Users\\DELL\\IdeaProjects\\Algo_P1\\src\\main\\java\\images\\img_3.png");

    @Override
    public void start(Stage primaryStage) {
        ImageView choseFileView = new ImageView(one);
        ImageView promptUserView = new ImageView(two);
        ImageView randView = new ImageView(three);
        ImageView resetView = new ImageView(reset);
        ImageView closeView = new ImageView(close);
        ImageView IconView = new ImageView(icon);
        ImageView startView = new ImageView(start);



        Label Welcome = new Label("Welcome To Tic Tac Toe Game, Lets Get Started!");
        Welcome.setStyle(LabelStyle);
        Button start = new Button("Start", startView);
        Button closee = new Button("Close", closeView);
        start.setStyle(btnStyle);
        closee.setStyle(btnStyle);
        closee.setOnAction(e->{
            primaryStage.close();
        });


        start.setPrefSize(200, 100);
        closee.setPrefSize(200, 100);
        choseFileView.setFitHeight(80);
        choseFileView.setFitWidth(80);
        promptUserView.setFitHeight(80);
        promptUserView.setFitWidth(80);
        randView.setFitHeight(80);
        randView.setFitWidth(80);
        startView.setFitHeight(80);
        startView.setFitWidth(80);
        closeView.setFitHeight(80);
        closeView.setFitWidth(80);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(1, 1, 10, 1));

        BorderPane borderPane = new BorderPane(vBox);
        borderPane.setCenter(vBox);
        borderPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, new CornerRadii(0), Insets.EMPTY)));
        Scene scene = new Scene(borderPane, 800, 700);
        vBox.getChildren().addAll(Welcome, start, closee);


        //=====================Main Window Scene=================//


         //main Anchor
        AnchorPane mainAnchorPane = new AnchorPane();
        //Left Anchor Which has the buttons
        AnchorPane lap = new AnchorPane();
        lap.setPrefWidth(200);
        lap.setPrefHeight(500);
        lap.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(lap, 0.0);
        AnchorPane.setTopAnchor(lap, 0.0);
        AnchorPane.setBottomAnchor(lap, 0.0);

        //Inner Anchor Put the inner anchor in the top left
        AnchorPane innerPane = new AnchorPane();
        innerPane.setPrefWidth(200);
        innerPane.setPrefHeight(100);
        innerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(innerPane, 0.0);
        AnchorPane.setTopAnchor(innerPane, 0.0);

        Label l = new Label("Zaid Zitawi-1203101");
        l.setStyle(LabelStyle);
        VBox vBoxzaid = new VBox(IconView, l);
        IconView.setFitWidth(50);
        IconView.setFitHeight(50);
        AnchorPane.setLeftAnchor(vBoxzaid, 20.0);
        AnchorPane.setTopAnchor(vBoxzaid, 10.0);
        AnchorPane.setRightAnchor(vBoxzaid, 0.0);
        vBoxzaid.setAlignment(Pos.CENTER);

        //The Right big anchor pane which has the Tic Tac Toe table
        Image game = new Image("C:\\Users\\DELL\\IdeaProjects\\Algo_P4\\src\\main\\java\\Images\\game.png");
        ImageView gameView = new ImageView(game);
        lap1 = new AnchorPane(gameView);
        lap1.setPrefWidth(600);
        lap1.setPrefHeight(500);
        AnchorPane.setLeftAnchor(lap1, 200.0);
        AnchorPane.setTopAnchor(lap1, 100.0);
        AnchorPane.setRightAnchor(lap1, 0.0);
        AnchorPane.setBottomAnchor(lap1, 0.0);



        //put it above lap1 at the top of the scene on the right of inner pane
        lap2 = new AnchorPane();
        lap2.setPrefWidth(600);
        lap2.setPrefHeight(100);
        lap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(lap2, 200.0);
        AnchorPane.setTopAnchor(lap2, 0.0);
        AnchorPane.setRightAnchor(lap2, 0.0);


        Separator separator1 = new Separator();
        separator1.setStyle("-fx-background-color: black");
        separator1.setPrefWidth(200);
        AnchorPane.setLeftAnchor(separator1, 0.0);
        AnchorPane.setTopAnchor(separator1, 100.0);
        AnchorPane.setRightAnchor(separator1, 0.0);
        lap.getChildren().add(separator1);

        Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.VERTICAL);
        separator2.setPrefHeight(100);
        separator2.setStyle("-fx-background-color: black");
        AnchorPane.setLeftAnchor(separator2, 200.0);
        AnchorPane.setTopAnchor(separator2, 0.0);
        AnchorPane.setBottomAnchor(separator2, 0.0);
        mainAnchorPane.getChildren().add(separator2);

        VBox v = new VBox();
        v.setAlignment(Pos.CENTER_LEFT);
        v.setSpacing(20);
        AnchorPane.setTopAnchor(v, 110.0);


        Button easyBtn = new Button("Easy", choseFileView);
        easyBtn.setPrefSize(200, 30);
        easyBtn.setStyle(ButtonStyle2);
        choseFileView.setFitWidth(50);
        choseFileView.setFitHeight(50);
        dropShadwo(easyBtn);

        twoplayersbtn = new Button("2 Players 1 VS 1 ", promptUserView);
        twoplayersbtn.setPrefSize(200, 30);
        twoplayersbtn.setStyle(ButtonStyle2);
        promptUserView.setFitHeight(50);
        promptUserView.setFitWidth(50);
        dropShadwo(twoplayersbtn);


        Button advancedbtn = new Button("Advanced", randView);
        advancedbtn.setPrefSize(200, 30);
        advancedbtn.setStyle(ButtonStyle2);
        randView.setFitWidth(50);
        randView.setFitHeight(50);
        dropShadwo(advancedbtn);

        Button resetbtn= new Button("Reset", resetView);
        resetbtn.setPrefSize(200, 30);
        resetbtn.setStyle(ButtonStyle2);
        resetView.setFitWidth(50);
        resetView.setFitHeight(50);
        dropShadwo(resetbtn);

        Button ExitButton = new Button("Back To Home Page", closeView);
        ExitButton.setPrefSize(200, 30);
        ExitButton.setStyle(ButtonStyle2);
        closeView.setFitHeight(50);
        closeView.setFitWidth(50);
        dropShadwo(ExitButton);
        ExitButton.setOnAction(e->{
            primaryStage.setScene(scene);
        });

        textArea = new TextArea();
        textArea.setPrefSize(300, 300); // Set preferred size (width, height)
        textArea.setEditable(false); // Make it non-editable if it's only for display
        textArea.setStyle(style); // Set style (optional)

        v.getChildren().addAll(easyBtn, twoplayersbtn, advancedbtn, resetbtn, ExitButton);
        innerPane.getChildren().add(vBoxzaid);
        lap.getChildren().addAll(innerPane, v);
        lap2.getChildren().addAll();
        mainAnchorPane.getChildren().addAll(lap, lap1, lap2);
        Scene zaid = new Scene(mainAnchorPane, 1100, 650);//Primary Scene
        primaryStage.setTitle("Main Window");
        primaryStage.getIcons().add(icon);

        start.setOnAction(e -> {
            primaryStage.setScene(zaid);
        });


        easyBtn.setOnAction(e -> {
            roundNumber=0;
            lap2.getChildren().clear();
            resetBoard(board);
            GridPane ticTacToeBoard = createEasyModeTicTacToeBoard();
            this.gridPane = ticTacToeBoard;
            isHumanVsComputerMode = true;
            showPlayerDetailsPrompt(); // Prompt for player details
            setupPlayerInfoDisplay(); // Setup the display of player info

            // Set the initial currentPlayer based on player's choice
            currentPlayer = player1.getxORo(); // Player's character

            // If the player chose 'O', computer (as 'X') makes the first move
            if (currentPlayer == PLAYER_O) {
                performComputerMove(PLAYER_X); // Computer plays 'X'
            }

            lap1.getChildren().clear();
            lap1.getChildren().add(ticTacToeBoard);
            AnchorPane.setTopAnchor(ticTacToeBoard, 50.0);
            AnchorPane.setLeftAnchor(ticTacToeBoard, 50.0);
        });




        twoplayersbtn.setOnAction(e -> {
            roundNumber=0;
            resetBoard(board);
            lap2.getChildren().clear();
            PromptForTwoPlayers();
            setup2PlayersInfo();
            isAIMode = false;
            gridPane = createTwoPlayerTicTacToeBoard();
            lap1.getChildren().clear();
            lap1.getChildren().add(gridPane);
            AnchorPane.setTopAnchor(gridPane, 50.0);
            AnchorPane.setLeftAnchor(gridPane, 250.0);
            System.out.println(player1.toString() + "\t" + player2.toString());
            });

        advancedbtn.setOnAction(e -> {
            resetBoard(board);
            isAIMode = true;
            roundNumber=1;
            lap2.getChildren().clear();
            showPlayerDetailsPrompt();
            setupPlayerInfoDisplay();
            this.gridPane = createTicTacToeBoard();
            initializeBoard();
            lap1.getChildren().clear();
            lap1.getChildren().addAll(gridPane, textArea);
            AnchorPane.setTopAnchor(gridPane, 50.0);
            AnchorPane.setLeftAnchor(gridPane, 150.0);
            AnchorPane.setTopAnchor(textArea, 50.0);
            AnchorPane.setRightAnchor(textArea, 50.0);

            if (player1.getxORo() == PLAYER_O) {
                int[] move = bestMove(player2.getxORo());
                if (move[0] != -1 && move[1] != -1) {
                    makeMove(move[0], move[1], player2.getxORo());
                    Button button = getButton(move[0], move[1]);
                    button.setText(String.valueOf(player2.getxORo()));
                    button.setDisable(true);
                }
            }
            System.out.println(player1.toString() + player2.toString());
        });

        resetbtn.setOnAction(event -> {
            resetBoardForNewGame();
        });






        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    //================Methods===================//




    private GridPane createTicTacToeBoard() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(15));
        grid.setHgap(15);// Check if a player has won enough rounds to end the game early
        grid.setVgap(15);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = createButton(i, j);
                grid.add(button, j, i);
                button.setStyle("-fx-background-color: #ffffff; " +
                        "-fx-border-color: #1abc9c; " +
                        "-fx-border-width: 2px; " +
                        "-fx-font-size: 32px; " +
                        "-fx-font-family: 'Arial'; " +
                        "-fx-text-fill: #2c3e50;");
                button.setEffect(new DropShadow(5, Color.GREY));
                button.setOnMouseEntered(e -> button.setStyle(button.getStyle() +
                        "-fx-background-color: #bdc3c7;"));
                button.setOnMouseExited(e -> button.setStyle(button.getStyle() +
                        "-fx-background-color: #ffffff;"));
            }
        }
        return grid;
    }



    private Button createButton(int row, int col) {
        Button button = new Button();
        button.setMinSize(100, 100);
        button.setFont(new Font("Arial", 24));
        button.setOnAction(e -> {
            if (board[row][col] == EMPTY) {
                char currentPlayerChar = getCurrentPlayerChar();
                makeMove(row, col, currentPlayerChar);
                button.setText(String.valueOf(currentPlayerChar));
                button.setDisable(true);


                if (!isWinner(currentPlayerChar) && !isBoardFull()) {

                    char nextPlayerChar;
                    if (currentPlayerChar == player1.getxORo()) {
                        nextPlayerChar = player2.getxORo();
                    } else {
                        nextPlayerChar = player1.getxORo();
                    }
                    int[] aiMove = bestMove(nextPlayerChar);
                    if (aiMove[0] != -1 && aiMove[1] != -1) {
                        makeMove(aiMove[0], aiMove[1], nextPlayerChar);
                    }
                }
            }
        });
        return button;
    }

    private char getCurrentPlayerChar() {
        //xCount and oCount, to keep track of the number of Xs and Os already placed on the board
        int xCount = 0;
        int oCount = 0;
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == PLAYER_X) {
                    xCount++;
                } else if (cell == PLAYER_O) {
                    oCount++;
                }
            }
        }

        char currentPlayerChar;
        if (xCount <= oCount) {
            currentPlayerChar = PLAYER_X; // It's X's turn
        } else {
            currentPlayerChar = PLAYER_O; // It's O's turn
        }
        return currentPlayerChar;//returns character('X' or 'O')of the player who should make the next move
    }

    private void makeMove(int row, int col, char player) {
        board[row][col] = player;
        if (player1.getWon() > totalrounds / 2 || player2.getWon() > totalrounds / 2) {
            showFinalResults();
            return; //exit
        }

        // Check if the game rounds are completed
        if (roundNumber >= totalrounds) {
            showFinalResults();
            return; // exit
        }

        Button button = getButton(row, col);
        if (button != null) {
            button.setText(String.valueOf(player));
            button.setDisable(true);
        }
        if (isWinner(player)) {
            showAlert(player + " wins!");
            if (player2.getxORo() == player) {
                player2.setWon(player2.getWon() + 1);
            }
//            updatePlayerInfoDisplay();
//            resetBoardForNewGame();
        } else if (isBoardFull()) {
            showAlert("It's a draw!");
            player1.setDraw(player1.getDraw() + 1);
            player2.setDraw(player2.getDraw() + 1);
//            updatePlayerInfoDisplay();
//            resetBoardForNewGame();
        } else {
            // If it's the AI's turn, schedule the AI move//player2 is for the AI
            if (player != player2.getxORo()) {
                // It's the AI's turn only if the current player "player" is not the AI
                char nextPlayer = switchPlayer(player);// method 5 //switch to AI
                if (nextPlayer == player2.getxORo()) { // if the next player is ai
                    int[] aiMove = bestMove(nextPlayer);// method 6
                    if (aiMove[0] != -1 && aiMove[1] != -1) {
                    }
                }
            }
        }
    }

    private char switchPlayer(char currentPlayer) {//currentplayer is ai
        if (currentPlayer == PLAYER_X) {
            return PLAYER_O;
        } else {
            return PLAYER_X;
        }
    }

    private int[] bestMove(char currentPlayer) {//method 6
        int bestScore;
        if (currentPlayer == PLAYER_O) {
            bestScore = Integer.MIN_VALUE; // O is the maximizing player
        } else {
            bestScore = Integer.MAX_VALUE; // X is the minimizing player
        }

        int[] bestMove = {-1, -1};// array is initialized to -1, -1,
        // which will hold the row and column indices of the best move found for the current player.

        StringBuilder stringBuilder = new StringBuilder();

        // Iterate through all the empty cells on the board
        //and start simulating each empty button
        for (int[] cell : getEmptyCells()) {
            board[cell[0]][cell[1]] = currentPlayer; // Make the move
            int score = minimax(switchPlayer(currentPlayer));//to simulate human moves
            board[cell[0]][cell[1]] = EMPTY; // Undo the move(((((because its simulation))))))

            if (score == 1){
                stringBuilder.append(String.format("Move at [%d, %d], Move state: %s\n", cell[0], cell[1], flag1));
            }else if (score==-1){
                stringBuilder.append(String.format("Move at [%d, %d], Move State: %s\n", cell[0], cell[1], flag2));
            }else {
                stringBuilder.append(String.format("Move at [%d, %d], Move State: %s\n", cell[0], cell[1], flag3));
            }


            //store the score var from minMax in bestScore var
            if ((currentPlayer == PLAYER_O && score > bestScore) || (currentPlayer == PLAYER_X && score < bestScore)) {
                bestScore = score;//here is stored either the maximum score by O or minimum score by X
                bestMove[0] = cell[0];
                bestMove[1] = cell[1];
            }
        }
        Platform.runLater(() -> textArea.setText(stringBuilder.toString()));
        return bestMove;
    }

    //Why arraylist?
    //Each int[] array in the list represents the coordinates of an empty cell on the board.
    private List<int[]> getEmptyCells() {
        List<int[]> emptyCells = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }
        return emptyCells;
    }

    private int minimax(char player) {
        //base cases
        if (isWinner(PLAYER_O)) return 1;
        if (isWinner(PLAYER_X)) return -1;
        List<int[]> emptyCells = getEmptyCells();
        if (emptyCells.isEmpty()) return 0;

        int score;
        int bestScore;
        if (player == PLAYER_O) {
            // Player O is the maximizing player
            bestScore = Integer.MIN_VALUE;
        } else {
            // Player X is the minimizing player
            bestScore = Integer.MAX_VALUE;
        }

        for (int[] cell : emptyCells) {
            board[cell[0]][cell[1]] = player;
            if (player == PLAYER_O) {
                score = minimax(PLAYER_X);//recursion
                bestScore = Math.max(score, bestScore);
            } else {
                score = minimax(PLAYER_O);
                bestScore = Math.min(score, bestScore);
            }
            board[cell[0]][cell[1]] = EMPTY; // Undo move
        }
        return bestScore;
    }


    //Check if one of the players wins(it must always be the AI)
    private boolean isWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;//row
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;//column
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;//diagonal
        return false;
    }


    //method to get a button from the GridPane
    private Button getButton(int row, int col) {
        for (javafx.scene.Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col) {
                return (Button) node;
            }
        }
        return null;
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }



    private void resetBoardForNewGame() {
        // Resets the board array
        initializeBoard();

        // Reset and enable all buttons on the grid
        for (Node node : gridPane.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setText("");
                button.setDisable(false);
            }
        }

        // Update the round number and display
        ++roundNumber;
        updatePlayerInfoDisplay();

        // Check if it's the AI mode and if the AI should start the game
        if (isAIMode && player1.getxORo() == PLAYER_O) {
            // AI starts the new game because player1 is O and it's AI mode
            int[] move = bestMove(PLAYER_X); // Assume AI is X
            if (move[0] != -1 && move[1] != -1) {
                Platform.runLater(() -> makeMove(move[0], move[1], PLAYER_X));
            }
        }
        else if (isHumanVsComputerMode && player1.getxORo() == PLAYER_O) {
            performComputerMove(player2.getxORo());
        }
        else {
            // In two-player mode, or if the AI is not supposed to start, Player X starts
            currentPlayer = PLAYER_X;
        }
    }


    // method to show an alert dialog
    private void showAlert(String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }

    // method to check if the board is full
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    //ask the user to enter his name and the character before playing, and the data of AI is stored by default
    private void showPlayerDetailsPrompt() {
        Stage promptStage = new Stage();
        promptStage.initModality(Modality.APPLICATION_MODAL);
        promptStage.setTitle("Player Details");

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));

        Label note = new Label("X has the first move");
        note.setStyle(LabelStyle);

        // Human player details
        Label playerLabel = new Label("Your Name:");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        ToggleGroup group = new ToggleGroup();
        RadioButton rbX = new RadioButton("X");
        rbX.setToggleGroup(group);
        rbX.setSelected(true);
        RadioButton rbO = new RadioButton("O");
        rbO.setToggleGroup(group);

        Label roundsnum = new Label("number of rounds");
        TextField roundnumtextfield = new TextField();
        roundnumtextfield.setPromptText("Enter rounds number");

        Button submitButton = new Button("Submit");
        submitButton.setStyle(btnStyle);
        submitButton.setOnAction(e -> {
            String playerName = nameField.getText();
            char playerChar = (group.getSelectedToggle() == rbX) ? 'X' : 'O';
            player1 = new Player(playerName, playerChar, 0, 0);

            // Create AI player with the opposite character
            char aiChar = (playerChar == 'X') ? 'O' : 'X';
            player2 = new Player("AI", aiChar, 0, 0);

            totalrounds =Integer.parseInt( roundnumtextfield.getText());

            promptStage.close();
        });

        vbox.getChildren().addAll(note, playerLabel, nameField, roundsnum, roundnumtextfield, new Label("Choose Your Character:"), rbX, rbO, submitButton);

        Scene scene = new Scene(vbox, 400, 400);
        promptStage.setScene(scene);
        promptStage.showAndWait();
    }


    private void setupPlayerInfoDisplay() {
        player1Info.setPrefSize(250, 80);
        player2Info.setPrefSize(250, 80);
        roundInfo.setPrefSize(250, 80);

        player1Info.setEditable(false);
        player1Info.setText(String.format("Player1 Name: %s\t\tChar: %s\nWon: %d\t\t\tDraw: %d",
                player1.getName(), player1.getxORo(), player1.getWon(), player1.getDraw()));

        roundInfo.setEditable(false);
        roundInfo.setText(String.format("                     Round: %d", roundNumber));

        player2Info.setEditable(false);
        player2Info.setText(String.format("Player2 Name: AI\t\tChar: %s\nWon: %d\t\t\tDraw: %d",
                player2.getxORo(), player2.getWon(), player2.getDraw()));


        player1Info.setStyle(style);
        roundInfo.setStyle(style);
        player2Info.setStyle(style);

        lap2.getChildren().add(player1Info);
        AnchorPane.setTopAnchor(player1Info, 10.0);
        AnchorPane.setLeftAnchor(player1Info, 10.0);

        lap2.getChildren().add(roundInfo);
        AnchorPane.setTopAnchor(roundInfo, 10.0);
        AnchorPane.setLeftAnchor(roundInfo, 320.0);

        lap2.getChildren().add(player2Info);
        AnchorPane.setTopAnchor(player2Info, 10.0);
        AnchorPane.setRightAnchor(player2Info, 20.0);
        }




    private void updatePlayerInfoDisplay() {
        player1Info.setText(String.format("Player1 Name: %s\nChar: %s\nWon: %d\nDraw: %d",
                player1.getName(), player1.getxORo(), player1.getWon(), player1.getDraw()));


        player2Info.setText(String.format("Player2 Name: %s\nChar: %s\nWon: %d\nDraw: %d",
                player2.getName(), player2.getxORo(), player2.getWon(), player2.getDraw()));

        // Update round info
        roundInfo.setText(String.format("Round:                      %d", roundNumber));
    }

    //=================2 Players Mode=======================//

    // Method to handle a move by a player
    private void handleTwoPlayerMove(int row, int col, Button btn) {
        Button button = getButton(row, col);
        assert button != null;

        if (button.getText().isEmpty()) {
            board[row][col] = currentPlayer;
            button.setText(String.valueOf(currentPlayer));
            button.setDisable(true);

            if (player1.getWon() > totalrounds / 2 || player2.getWon() > totalrounds / 2) {
                showFinalResults();
                return; //exit
            }

            // Check if the game rounds are completed
            if (roundNumber >= totalrounds) {
                showFinalResults();
                return; // exit
            }

            if (isWinner(currentPlayer)) {
                showAlert(currentPlayer + " wins!");
                if (player1.getxORo() == currentPlayer) {
                    player1.setWon(player1.getWon() + 1);
                }else {
                    player2.setWon(player2.getWon()+1);
                }
                resetBoardForNewGame();
                updatePlayerInfoDisplay();
            } else if (isBoardFull()) {
                showAlert("It's a draw!");
                resetBoardForNewGame();
                player1.setDraw(player1.getDraw() + 1);
                player2.setDraw(player2.getDraw() + 1);
                updatePlayerInfoDisplay();
            } else {
                switchPlayer(); // Switch to the other player
            }
        }
    }


    private void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    private GridPane createTwoPlayerTicTacToeBoard() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(15));
        grid.setHgap(15);
        grid.setVgap(15);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setMinSize(100, 100);
                button.setFont(new Font("Arial", 24));
                final int row = i; // These need to be final for use in the lambda
                final int col = j;
                button.setOnAction(e -> handleTwoPlayerMove(row, col, button));
                grid.add(button, j, i);
                button.setStyle("-fx-background-color: #ffffff; " +
                        "-fx-border-color: #1abc9c; " +
                        "-fx-border-width: 2px; " +
                        "-fx-font-size: 32px; " +
                        "-fx-font-family: 'Arial'; " +
                        "-fx-text-fill: #2c3e50;");
                button.setEffect(new DropShadow(5, Color.GREY));
                button.setOnMouseEntered(e -> button.setStyle(button.getStyle() +
                        "-fx-background-color: #bdc3c7;"));
                button.setOnMouseExited(e -> button.setStyle(button.getStyle() +
                        "-fx-background-color: #ffffff;"));
            }
        }
        return grid;
    }

    private void resetBoard(char [][] board){
        for (int i=0;i<3;i++){
            for (int j=0 ; j<3 ;j++){
                board[i][j]= EMPTY;
            }
        }
    }



    //2 Human Players
    private void PromptForTwoPlayers() {
        Stage promptStage = new Stage();
        promptStage.initModality(Modality.APPLICATION_MODAL);
        promptStage.setTitle("Player Details");

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));

        Label note = new Label("X has the first move");
        note.setStyle(LabelStyle);
        // Player 1 details
        Label player1Label = new Label("Player 1 Name:");
        TextField player1NameField = new TextField();
        player1NameField.setPromptText("Enter Player 1 name");

        // Player 2 details
        Label player2Label = new Label("Player 2 Name:");
        TextField player2NameField = new TextField();
        player2NameField.setPromptText("Enter Player 2 name");

        Label roundsnum = new Label("number of rounds");
        TextField roundnumtextfield = new TextField();
        roundnumtextfield.setPromptText("Enter rounds number");

        ToggleGroup group = new ToggleGroup();
        RadioButton rbX = new RadioButton("X for Player 1");
        rbX.setToggleGroup(group);
        rbX.setSelected(true);
        RadioButton rbO = new RadioButton("O for Player 1");
        rbO.setToggleGroup(group);

        Button submitButton = new Button("Submit");
        submitButton.setStyle(btnStyle);
        submitButton.setOnAction(e -> {
            String player1Name = player1NameField.getText();
            String player2Name = player2NameField.getText();
            char player1Char = (group.getSelectedToggle() == rbX) ? 'X' : 'O';
            char player2Char = (player1Char == 'X') ? 'O' : 'X';

            player1 = new Player(player1Name, player1Char, 0, 0);
            player2 = new Player(player2Name, player2Char, 0, 0);
            totalrounds=Integer.parseInt(roundnumtextfield.getText());
            promptStage.close();
        });

        vbox.getChildren().addAll(note, player1Label, player1NameField, player2Label, player2NameField, roundsnum, roundnumtextfield, new Label("Choose Player 1 Character:"), rbX, rbO, submitButton);

        Scene scene = new Scene(vbox, 400, 400);
        promptStage.setScene(scene);
        promptStage.showAndWait();
    }

    private void setup2PlayersInfo() {
        player1Info.setPrefSize(250, 80);
        player2Info.setPrefSize(250, 80);
        roundInfo.setPrefSize(250, 80);

        player1Info.setEditable(false);
        player1Info.setText(String.format("Player1 Name: %s\t\tChar: %s\nWon: %d\t\t\tDraw: %d",
                player1.getName(), player1.getxORo(), player1.getWon(), player1.getDraw()));

        roundInfo.setEditable(false);
        roundInfo.setText(String.format("                     Round: %d", roundNumber));

        player2Info.setEditable(false);
        player2Info.setText(String.format("Player2 Name: %s\t\tChar: %s\nWon: %d\t\t\tDraw: %d",
                player2.getName(), player2.getxORo(), player2.getWon(), player2.getDraw()));


        player1Info.setStyle(style);
        roundInfo.setStyle(style);
        player2Info.setStyle(style);


        lap2.getChildren().addAll(player1Info, player2Info, roundInfo);
        AnchorPane.setTopAnchor(player1Info, 10.0);
        AnchorPane.setLeftAnchor(player1Info, 10.0);


        AnchorPane.setTopAnchor(roundInfo, 10.0);
        AnchorPane.setLeftAnchor(roundInfo, 320.0);


        AnchorPane.setTopAnchor(player2Info, 10.0);
        AnchorPane.setRightAnchor(player2Info, 20.0);
        }

    private void showFinalResults() {
        Stage resultsStage = new Stage();
        resultsStage.initModality(Modality.APPLICATION_MODAL);
        resultsStage.setTitle("Final Results");

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        // Display final results
        Label resultsLabel = new Label("Game Over! Final Results:");
        Label player1Result = new Label(String.format("%s: %d Wins, %d Draws", player1.getName(), player1.getWon(), player1.getDraw()));
        Label player2Result = new Label(String.format("%s: %d Wins, %d Draws", player2.getName(), player2.getWon(), player2.getDraw()));

        resultsLabel.setStyle(LabelStyle);
        player1Result.setStyle(LabelStyle);
        player2Result.setStyle(LabelStyle);


        // Button to play again
        Button playAgainButton = new Button("Play Again");
        playAgainButton.setStyle(btnStyle);
        playAgainButton.setOnAction(e -> {
            resultsStage.close(); // Close the results stage
//            twoplayersbtn.fire(); // Restart the two player mode
        });

        Button btn = new Button("Continue Game");
        btn.setStyle(btnStyle);

        btn.setOnAction(e->{
            resultsStage.close();
        });

        vbox.getChildren().addAll(resultsLabel, player1Result, player2Result, playAgainButton, btn);

        Scene scene = new Scene(vbox, 400, 400);
        resultsStage.setScene(scene);
        resultsStage.showAndWait();
    }



    //===================== Randome Computer =================================//

    private GridPane createEasyModeTicTacToeBoard() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(15));
        grid.setHgap(15);
        grid.setVgap(15);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setMinSize(100, 100);
                button.setFont(new Font("Arial", 24));
                final int row = i;
                final int col = j;
                button.setOnAction(e -> handleEasyModeMove(row, col, button));
                grid.add(button, j, i);
                button.setStyle("-fx-background-color: #ffffff; " +
                        "-fx-border-color: #1abc9c; " +
                        "-fx-border-width: 2px; " +
                        "-fx-font-size: 32px; " +
                        "-fx-font-family: 'Arial'; " +
                        "-fx-text-fill: #2c3e50;");
                button.setEffect(new DropShadow(5, Color.GREY));
                button.setOnMouseEntered(e -> button.setStyle(button.getStyle() +
                        "-fx-background-color: #bdc3c7;"));
                button.setOnMouseExited(e -> button.setStyle(button.getStyle() +
                        "-fx-background-color: #ffffff;"));
            }
        }
        return grid;
    }

    private void handleEasyModeMove(int row, int col, Button btn) {

        if (player1.getWon() > totalrounds / 2 || player2.getWon() > totalrounds / 2) {
            showFinalResults();
            return; //exit
        }
        // Check if the game rounds are completed
        if (roundNumber >= totalrounds) {
            showFinalResults();
            return; // exit
        }
        if (btn.getText().isEmpty()) {
            board[row][col] = currentPlayer;
            btn.setText(String.valueOf(currentPlayer));
            btn.setDisable(true);

            // Check for player win or draw
            if (isWinner(currentPlayer)) {
                showAlert(currentPlayer + " wins!");
                if (player1.getxORo() == currentPlayer) {
                    player1.setWon(player1.getWon() + 1);
                }else {
                    player2.setWon(player2.getWon()+1);
                }
                updatePlayerInfoDisplay();

            } else if (isBoardFull()) {
                showAlert("It's a draw!");
                player1.setDraw(player1.getDraw() + 1);
                player2.setDraw(player2.getDraw() + 1);
                updatePlayerInfoDisplay();

            }else {
                // Perform computer move after the player's move
                char computerChar = currentPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
                Platform.runLater(() -> {
                    performComputerMove(computerChar);
                });
            }
        }
    }

    private void performComputerMove(char computerChar) {
        List<int[]> emptyCells = getEmptyCells();
        if (emptyCells.isEmpty()) return; // No move to make

        Random rand = new Random();
        int[] move = emptyCells.get(rand.nextInt(emptyCells.size()));
        board[move[0]][move[1]] = computerChar;

        Button button = getButton(move[0], move[1]);
        if (button != null) {
            button.setText(String.valueOf(computerChar));
            button.setDisable(true);
        }

        if (isWinner(computerChar)) {
            showAlert("Computer wins!");
            player2.setWon(player2.getWon()+1);
            updatePlayerInfoDisplay();
        } else if (isBoardFull()) {
            showAlert("It's a draw!");
            player1.setDraw(player1.getDraw() + 1);
            player2.setDraw(player2.getDraw() + 1);
            updatePlayerInfoDisplay();
        }
    }



    //Add Effects to the Buttons
    public void dropShadwo(Button btn) {
        // Add an effect to the button
        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setRadius(10);
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        btn.setEffect(dropShadow);
        // Increase the opacity of the shadow when the mouse is over the button
        btn.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        btn.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow.setColor(Color.rgb(0, 0, 0, 0.5)));
    }


    // Main method
    public static void main(String[] args) {
        launch(args);
    }
}