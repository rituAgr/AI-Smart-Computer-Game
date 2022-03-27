package game;

//The board contain 3*3 blocks
class block
{
    position pos;
    boolean Occupied;
    mark M;
    block(position pos)
    {
        this.pos=pos;
        Occupied=false;
        M=null;
    }
    boolean isOccupied()
    {
        return Occupied;
    }
    void setMark(mark M)
    {
        Occupied=true;
        this.M=M;
    }
}
