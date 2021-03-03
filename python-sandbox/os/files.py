import os

dir_path = os.path.dirname(os.path.realpath(__file__))


def pwd():
    print("dir_path: " + dir_path)


if __name__ == '__main__':
    pwd()
